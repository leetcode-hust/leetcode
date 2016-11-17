package effectivejava;

import java.io.Serializable;

/**
 * Created by louyuting on 16/11/11.
 */
public class Customer implements Serializable{
    private String name;
    private String age;

    public Customer(String age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + this.name + ", age="+this.age;
    }
}
