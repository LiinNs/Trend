package xyz.liinns.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.util.Assert;
import xyz.liinns.entity.SysPropertyResource;
import xyz.liinns.mapper.SysPropertyResourceMapper;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class DatabaseProperty {

    private static final Pattern PATTEN_OF_APP_CONFIG = Pattern.compile("^applicationConfig.*");

    private ConfigurableEnvironment environment;

    private SysPropertyResourceMapper propertyResourceMapper;



    @Autowired
    public DatabaseProperty(ConfigurableEnvironment environment,
                            SysPropertyResourceMapper propertyResourceMapper) {
        Assert.notNull(propertyResourceMapper, "sys_property is required!");
        log.info("\n-------------------------- sys_property --------------------------");
        this.environment = environment;
        this.propertyResourceMapper = propertyResourceMapper;
    }

    @PostConstruct
    public void initializeDatabasePropertySourceUsage() {
        MutablePropertySources propertySources = environment.getPropertySources();
        try {
            Map<String, Object> propertyMap = propertyResourceMapper.selectAll().stream()
                    .collect(Collectors.toMap(SysPropertyResource::getPropertyName, SysPropertyResource::getPropertyValue));
            Properties properties = new Properties();
            properties.putAll(propertyMap);
            PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
            String name = null;
            boolean flag = false;
            for (PropertySource<?> source : propertySources) {
                if (PATTEN_OF_APP_CONFIG.matcher(source.getName()).matches()) {
                    name = source.getName();
                    flag = true;
                    log.info("Find propertySources ".concat(name));
                    break;
                }
            }
            if(flag) {
                propertySources.addBefore(name, dbPropertySource);
            } else {
                propertySources.addFirst(dbPropertySource);
            }
        } catch (Exception e) {
            log.error("Error during database properties setup", e);
            throw new RuntimeException(e);
        }
    }


}
