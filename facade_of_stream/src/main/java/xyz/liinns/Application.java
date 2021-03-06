package xyz.liinns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import xyz.liinns.mongodb.CityRepository;
import xyz.liinns.mongodb.domain.City;

/**
 * Description:
 * Created by LiinNs on 2017-4-10 0010.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CityRepository repository;

    public static void main(String[] args) {
        System.setProperty("user.timezone", "Asia/Shanghai");
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    /*@Bean
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
    }*/

    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();
        this.repository.save(new City("海口","570100"));
        this.repository.save(new City("临高","571800"));

        for (City city : this.repository.findAll()) {
            System.out.println(city);
        }

        System.out.println(this.repository.findByNameAndZipCode("海口", "570100"));
    }
}
