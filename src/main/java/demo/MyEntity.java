package demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Status status = Status.BAD;

    private int counter = 0;



    public static boolean methodUsingLazyLoading(MyEntity myEntity) {

        myEntity.setCounter(myEntity.getCounter() + 1);

        return true;
    }

    public void changeStatus() {
        status = Status.values()[1 - status.ordinal()];
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", status=" + status +
                ", counter=" + counter +
                '}';
    }
}

