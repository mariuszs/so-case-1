package demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class BeanA {

    private static final Logger LOGGER = getLogger(BeanA.class);

    private final MyEntityRepository repository;
    private final BeanB beanB;

    @Autowired
    public BeanA(MyEntityRepository repository, BeanB beanB) {
        this.repository = repository;
        this.beanB = beanB;
    }

    @Transactional(readOnly = false)
    public void doSomething() {

        LOGGER.error("doSomething");

        List<MyEntity> entities = repository.findAll();

        entities.stream().forEach(e -> e.setCounter(e.getCounter() + 1));

        entities.stream().filter(MyEntity::methodUsingLazyLoading)
                .forEach(entity -> beanB.doSomethingMore(entity));
    }
}
