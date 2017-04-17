package xyz.liinns.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Created by LiinNs on 2017-4-13-0013.
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class JtaConfig {

    @Bean(destroyMethod = "close", initMethod = "init")
    public UserTransactionManager userTransactionManager() {
        log.info("\n------------------------------- UserTransactionManager -------------------------------");
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    @Bean
    public UserTransactionImp userTransactionImp(){
        log.info("\n------------------------------- UserTransactionImp -------------------------------");
        return new UserTransactionImp();
    }

    @Bean
    public JtaTransactionManager transactionManager() {
        log.info("\n------------------------------- JtaTransactionManager -------------------------------");
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(userTransactionManager());
        jtaTransactionManager.setUserTransaction(userTransactionImp());
        return jtaTransactionManager;
    }

}
