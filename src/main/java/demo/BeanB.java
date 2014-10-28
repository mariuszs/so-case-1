package demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class BeanB {

    private static final Logger LOGGER = getLogger(BeanB.class);

    private final TransactionTemplate transactionTemplate;

    @Autowired
    public BeanB(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public void doSomethingMore(MyEntity entity) {
        LOGGER.warn("doSomethingMore {}", entity);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                entity.changeStatus();
            }
        });
    }
}
