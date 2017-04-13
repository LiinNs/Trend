package xyz.liinns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by LiinNs on 2017-4-13-0013.
 */
@Configuration
public class MapperScannerConfig {

    public static final String MAPPER_BASE_PACKAGE = "xyz.liinns.mapper";
    public static final String MAPPER_BASE_LOCATION = "classpath:mapper/*.xml";

    @Bean
    public MapperScannerConfigurer trendMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = getMapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(MybatisConfig.NAME + "SqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(MAPPER_BASE_PACKAGE);
        return mapperScannerConfigurer;
    }

    private MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.registerMapper(MySqlMapper.class);
        mapperHelper.registerMapper(Mapper.class);
        mapperScannerConfigurer.setMapperHelper(mapperHelper);
        Properties properties = new Properties();
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
