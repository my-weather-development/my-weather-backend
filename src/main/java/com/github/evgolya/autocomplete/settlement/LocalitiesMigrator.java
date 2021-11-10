package com.github.evgolya.autocomplete.settlement;

import com.github.evgolya.autocomplete.country.Country;
import com.github.evgolya.autocomplete.domain.Domain;
import com.github.evgolya.migration.settlements.CountryDto;
import com.github.evgolya.migration.settlements.DomainDto;
import com.github.evgolya.migration.settlements.SettlementDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LocalitiesMigrator {

    private final SettlementRepository settlementRepository;

    public LocalitiesMigrator(SettlementRepository settlementRepository) {
        this.settlementRepository = settlementRepository;
    }

    @Transactional
    public void saveLocalities(Map<CountryDto, Map<DomainDto, List<SettlementDto>>> localities) {
        final List<Settlement> settlementsToDb = new ArrayList<>();
        for (Map.Entry<CountryDto, Map<DomainDto, List<SettlementDto>>> entry : localities.entrySet()) {
            final Country country = new Country();
            final CountryDto countryDto = entry.getKey();
            country.setTitle(countryDto.getTitle());
            country.setCountryCode(countryDto.getCountryCode());

            final List<Domain> domains = new ArrayList<>();
            for (Map.Entry<DomainDto, List<SettlementDto>> innerEntry : entry.getValue().entrySet()) {
                final Domain domain = createDomainWithoutSettlements(innerEntry.getKey(), country);
                final List<Settlement> settlements = createSettlements(innerEntry.getValue(), domain);
                domain.setSettlements(settlements);
                settlementsToDb.addAll(settlements);
                domains.add(domain);
            }
            country.setDomains(domains);
        }
        settlementRepository.saveAll(settlementsToDb);
    }

    private Domain createDomainWithoutSettlements(DomainDto domainDto, Country country) {
        final Domain domain = new Domain();
        domain.setTitle(domainDto.getTitle());
        domain.setState(domainDto.isState());
        domain.setCountry(country);
        return domain;
    }

    private List<Settlement> createSettlements(List<SettlementDto> settlementDtos, Domain domain) {
        return settlementDtos.stream()
            .map(dto -> Settlement.builder()
                .setDomain(domain)
                .setLocality(dto.getLocality())
                .setAscii(dto.getAscii())
                .setLatitude(dto.getLatitude())
                .setLongitude(dto.getLongitude())
                .build()
            )
            .collect(Collectors.toList());
    }
}
