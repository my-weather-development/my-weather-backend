package com.github.evgolya.autocomplete;

import com.github.evgolya.geolocationapi.locality.SearchedLocality;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class LocalityAutocompleteService {

    private static final int TOP_10_LOCALITIES = 10;
    private final LocalityAutocompleteRepository localityAutocompleteRepository;
    private final CacheManager cacheManager;


    public LocalityAutocompleteService(
        LocalityAutocompleteRepository localityAutocompleteRepository,
        CacheManager cacheManager
    ) {
        this.localityAutocompleteRepository = localityAutocompleteRepository;
        this.cacheManager = cacheManager;
    }

    // locality = Chi/Ki/Kie/Kiev/Cher
    public LocalityAutocompleteDto getLocalitiesAutocomplete(String locality, String ip) {
        final String country = getCachedLocalityByIp(ip).getCountry(); // TODO: handle case for states in the USA

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

    private SearchedLocality getCachedLocalityByIp(String ip) {
        final Cache cache = cacheManager.getCache("localities");
        return cache.get(ip, SearchedLocality.class); // TODO: fix NPE
    }
}
