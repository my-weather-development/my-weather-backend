package com.github.evgolya.migration.settlements;

import com.github.evgolya.autocomplete.settlement.LocalitiesMigrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalitiesMigrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalitiesMigrationController.class);
    private final LocalitiesMigrator localitiesMigrator;
    private final LocalitiesCsvParser localitiesCsvParser;

    public LocalitiesMigrationController(LocalitiesMigrator localitiesMigrator, LocalitiesCsvParser localitiesCsvParser) {
        this.localitiesMigrator = localitiesMigrator;
        this.localitiesCsvParser = localitiesCsvParser;
    }

    @GetMapping("/migrate/localities")
    public void migrateSettlements() {
        try {
            localitiesMigrator.saveLocalities(localitiesCsvParser.parse());
            LOGGER.info("The migration was successful");
        } catch (Exception e) {
            LOGGER.error("The migration of settlements didn't success");
        }
    }
}
