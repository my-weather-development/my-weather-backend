package com.github.evgolya.autocomplete;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class LocalityAutocompleteService {

    private static final int TOP_10_LOCALITIES = 10;
    private final LocalityAutocompleteRepository localityAutocompleteRepository;

    public LocalityAutocompleteService(LocalityAutocompleteRepository localityAutocompleteRepository) {
        this.localityAutocompleteRepository = localityAutocompleteRepository;
    }

    public LocalityAutocompleteDto getLocalitiesAutocomplete(String locality) {
        final List<Settlement> settlements = localityAutocompleteRepository.findAll();

        // TODO: search all matches by locality, in java filter by country and sort by alphabet
        // TODO: setup database
        final List<LocalityAutocomplete> localities = settlements.stream()
            .filter(settlement -> !Pattern.matches(locality, settlement.getLocality()))
            .limit(TOP_10_LOCALITIES)
            .map(settlement -> new LocalityAutocomplete()
                .setLocality(settlement.getLocality())
                .setCountry(settlement.getCountry())
                .setRegion(settlement.getRegion())
                .setState(settlement.getState())
            ).collect(Collectors.toList());

        return new LocalityAutocompleteDto(localities);
    }
}
