package xyz.liinns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Description:
 * Created by LiinNs on 2017-4-14 0014.
 */
@Configuration
public class FlywayConfig {

    @Autowired
    @Qualifier("trendDataSource")
    private DataSource trendDataSource;

    @Value("${flyway.locations}")
    private String[] locations;

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            flyway.setBaselineOnMigrate(true);
            flyway.setDataSource(trendDataSource);
            flyway.setLocations(locations);
            flyway.setEncoding("UTF-8");
        };
    }
}
