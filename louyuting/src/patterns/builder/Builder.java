package patterns.builder;

/**
 * Created by louyuting on 17/1/6.
 */
public interface Builder {
    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();
}
