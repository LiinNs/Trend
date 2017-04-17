package xyz.liinns.config;

import com.github.benmanes.caffeine.cache.CaffeineSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Description:
 * Created by LiinNs on 2017-4-17 0017.
 */
@Configuration
@EnableCaching
@Slf4j
public class CacheConfig {

    @Bean
    @Primary
    public CacheManager primaryCacheManager(){
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeineSpec(CaffeineSpec.parse("maximumSize=1000,expireAfterWrite=300s"));
        caffeineCacheManager.setAllowNullValues(false);
        log.info("\n" + "============================================================================\n"
                    + "Using cache manager: " + caffeineCacheManager.getClass().getName() + "\n"
                    + "============================================================================\n");
        return caffeineCacheManager;
    }
}
