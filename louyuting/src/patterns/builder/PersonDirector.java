package patterns.builder;

/**
 * Created by louyuting on 17/1/6.
 */
public class PersonDirector {
    public Person constructPerson(Builder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}
