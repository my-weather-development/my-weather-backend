package com.github.evgolya.autocomplete.settlement;

import com.github.evgolya.autocomplete.country.CountryRepository;
import com.github.evgolya.autocomplete.domain.DomainRepository;
import com.github.evgolya.migration.settlements.LocalityDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalitiesMigrator {

    private final SettlementRepository settlementRepository;
    private final CountryRepository countryRepository;
    private final DomainRepository domainRepository;

    public LocalitiesMigrator(SettlementRepository settlementRepository, CountryRepository countryRepository, DomainRepository domainRepository) {
        this.settlementRepository = settlementRepository;
        this.countryRepository = countryRepository;
        this.domainRepository = domainRepository;
    }

    @Transactional
    public void save(List<LocalityDto> localityDtos) {
        // TODO: save data to DB
    }
}
