package patterns.builder;

/**
 * Created by louyuting on 17/1/6.
 */
public class WomanBuilder implements Builder{
    Person person;

    public WomanBuilder() {
        person = new Woman();
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造女人的脚");
    }
    @Override
    public void buildHead() {
        person.setHead("建造女人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("建造女人的身体");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
