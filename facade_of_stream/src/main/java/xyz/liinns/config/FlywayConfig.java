package xyz.liinns.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

/**
 * Description:
 * Created by LiinNs on 2017-4-14 0014.
 */
@Configuration
@Slf4j
public class FlywayConfig {

    @Value("${flyway.locations}")
    private String[] locations;

    @Autowired
    private DataSource trendDataSource;

    @Bean
    @DependsOn("trendDataSource")
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            log.info("\n-------------------------- flyway --------------------------");
            flyway.setDataSource(trendDataSource);
            flyway.setSchemas("trend");
            flyway.setLocations(locations);
            flyway.setBaselineOnMigrate(true);
            flyway.setValidateOnMigrate(true);
            flyway.repair();
            flyway.migrate();
        };
    }

}
