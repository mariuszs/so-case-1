package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Launcher {

    private final BeanA beanA;

    @Autowired
    public Launcher(BeanA beanA) {
        this.beanA = beanA;
    }

    @Scheduled(fixedDelay=5000)
    public void doit(){
        beanA.doSomething();

        System.out.println("XXXXXXXXXXXXXXXX");

    }
}
