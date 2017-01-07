package patterns.builder;

/**
 * Created by louyuting on 17/1/6.
 */
public class ManBuilder implements Builder{
    Person person;

    public ManBuilder() {
        this.person = new Man();
    }

    @Override
    public void buildBody() {
        person.setBody("建造男人的身体");
    }

    @Override
    public void buildHead() {
        person.setHead("建造男人的头");
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造男人的脚");
    }

    @Override
    public Person buildPerson() {
        return this.person;
    }
}
