package com.github.evgolya.migration.settlements;

import com.github.evgolya.autocomplete.country.CountryCodeWithStates;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LocalitiesCsvParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalitiesCsvParser.class);
    private static final String SETTLEMENTS_CSV = "settlements/settlements.csv";
    private static final int NUMBER_OF_LINES_TO_SKIP = 1;

    private final Set<String> countryCodeWithStates;

    public LocalitiesCsvParser() {
        this.countryCodeWithStates = Arrays.stream(CountryCodeWithStates.values())
            .map(CountryCodeWithStates::name)
            .collect(Collectors.toSet());
    }

    public Map<CountryDto, Map<DomainDto, List<SettlementDto>>> parse() {
        LOGGER.info("Starting parsing of settlements");
        try (
            final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(SETTLEMENTS_CSV);
            final CSVReader csvReader = new CSVReader(new InputStreamReader(nullOrInputStream(inputStream)))
        ) {
            final Map<CountryDto, Map<DomainDto, List<SettlementDto>>> result = new HashMap<>();

            csvReader.skip(NUMBER_OF_LINES_TO_SKIP);
            for (String[] line : csvReader.readAll()) {
                final String administrativeTerritorialUnit = line[7];
                final Double latitude = Double.valueOf(line[2]);
                final Double longitude = Double.valueOf(line[3]);
                final String localityAscii = line[1];
                final String countryCode = line[6];
                final String locality = line[0];
                final String country = line[4];

                final CountryDto countryDto = new CountryDto()
                    .setTitle(country)
                    .setCountryCode(countryCode);
                final DomainDto domainDto = new DomainDto()
                    .setTitle(administrativeTerritorialUnit)
                    .setIsState(countryCodeWithStates.contains(countryCode));
                final SettlementDto settlementDto = new SettlementDto()
                    .setAscii(localityAscii)
                    .setLocality(locality)
                    .setLatitude(latitude)
                    .setLongitude(longitude);

                result.computeIfAbsent(countryDto, k -> new HashMap<>())
                    .computeIfAbsent(domainDto, k -> new ArrayList<>())
                    .add(settlementDto);
            }
            LOGGER.info("Settlements were parsed");

            return result;
        } catch (IOException | CsvException e) {
            throw new CannotReadCSVException("Cannot parse CSV file: " + SETTLEMENTS_CSV, e);
        }
    }

    private InputStream nullOrInputStream(InputStream inputStream) {
        if (inputStream == null) {
            throw new CannotReadCSVException("Cannot find CSV file with name: " + SETTLEMENTS_CSV);
        }
        return inputStream;
    }

    private static final class CannotReadCSVException extends RuntimeException {

        private CannotReadCSVException(String message) {
            super(message);
        }

        private CannotReadCSVException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
