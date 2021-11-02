package com.github.evgolya.autocomplete;

import com.github.evgolya.migration.settlements.SettlementDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettlementService {

    private final SettlementRepository settlementRepository;

    public SettlementService(SettlementRepository settlementRepository) {
        this.settlementRepository = settlementRepository;
    }

    public List<Settlement> save(List<SettlementDto> settlementDtos) {
        final List<Settlement> settlements = settlementDtos.stream()
            .map(this::createSettlement)
            .collect(Collectors.toList());
        return settlementRepository.saveAll(settlements);
    }

    private Settlement createSettlement(SettlementDto dto) {
        final Settlement settlement = new Settlement();
        settlement.setCountry(dto.getCountry());
        settlement.setCountryCode(dto.getCountryCode());
        settlement.setRegion(dto.getRegion());
        settlement.setState(dto.getState());
        settlement.setLocality(dto.getLocality());
        settlement.setLocalityAscii(dto.getLocalityAscii());
        settlement.setLatitude(dto.getLatitude());
        settlement.setLongitude(dto.getLongitude());
        return settlement;
    }
}
