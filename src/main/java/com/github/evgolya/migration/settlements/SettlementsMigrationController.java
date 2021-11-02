package com.github.evgolya.migration.settlements;

import com.github.evgolya.autocomplete.Settlement;
import com.github.evgolya.autocomplete.SettlementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettlementsMigrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettlementsMigrationController.class);
    private final SettlementService settlementService;
    private final SettlementsCsvParser settlementsCsvParser;

    public SettlementsMigrationController(SettlementService settlementService, SettlementsCsvParser settlementsCsvParser) {
        this.settlementService = settlementService;
        this.settlementsCsvParser = settlementsCsvParser;
    }

    @GetMapping("/migrate/settlements")
    public void migrateSettlements() {
        try {
            final List<Settlement> settlements = settlementService.save(settlementsCsvParser.parse());
            if (settlements == null || settlements.isEmpty()) {
                LOGGER.error("The migration of settlements didn't success");
                return;
            }
            LOGGER.info("The migration of settlements was success");
        } catch (Exception e) {
            LOGGER.error("The migration of settlements didn't success");
        }
    }
}
