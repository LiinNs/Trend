package xyz.liinns.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * Created by LiinNs on 2017-4-13-0013.
 */
@Configuration
public class MybatisConfig {

    public static final String NAME = "trend";

    @Value("${spring.datasource.type}")
    private String dsType;

    @Primary
    @Bean(name = NAME + "DataSource")
    @ConfigurationProperties(prefix = "${spring.datasource}")
    @SuppressWarnings("unchecked")
    public DataSource trendDataSource() throws ClassNotFoundException {
        return DataSourceBuilder.create()
                .type((Class<? extends DataSource>) Class.forName(dsType))
                .build();
    }

    @Bean
    public AtomikosDataSourceBean trendAtomikosDataSourceBean() throws ClassNotFoundException {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("trendAtomikosDataSource");
        atomikosDataSourceBean.setXaDataSource((XADataSource) trendDataSource());
        return atomikosDataSourceBean;
    }

    @Bean(name = NAME + "SqlSessionFactory")
    public SqlSessionFactory trendSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(trendAtomikosDataSourceBean());
        bean.setTypeAliasesPackage(MapperScannerConfig.MAPPER_BASE_PACKAGE);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(MapperScannerConfig.MAPPER_BASE_LOCATION));
        SqlSessionFactory sqlSessionFactory = bean.getObject();
        specialTypeHandlerRegistry(sqlSessionFactory);
        return sqlSessionFactory;
    }

    //特殊类型的处理Handler注册
    private void specialTypeHandlerRegistry(SqlSessionFactory sqlSessionFactory) {
        TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
    }

    @Bean(name = NAME + "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(trendSqlSessionFactoryBean());
    }
}
