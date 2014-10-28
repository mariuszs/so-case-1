package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private MyEntityRepository repository;

    @Autowired
    private BeanA beanA;

    @Override
    public void run(String... strings) throws Exception {


        // save a couple of customers
        repository.save(new MyEntity());

        repository.flush();

        List<MyEntity> all = repository.findAll();

        System.out.println(all.size());


    }
}
