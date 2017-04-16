package xyz.liinns;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * Description:
 * Created by LiinNs on 2017-4-10 0010.
 */
@SpringBootApplication
public class Application /*implements CommandLineRunner */{

    public static void main(String[] args) {
        System.setProperty("user.timezone", "Asia/Shanghai");
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("------- Let's inspect the beans provided by Spring Boot -------");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            System.out.println("---------------------------- properties ----------------------------");
            Properties properties = System.getProperties();
            for (Map.Entry entry : properties.entrySet()) {
                System.out.println(String.format("%30s", entry.getKey().toString()) + "===:===" + entry.getValue());
            }
        };
    }

}
