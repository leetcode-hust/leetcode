package patterns.builder;

/**
 * Created by louyuting on 17/1/6.
 */
public class Client {
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Person manPerson = pd.constructPerson(new ManBuilder());
        System.out.println(manPerson.getBody()+"-"+ manPerson.getHead()+"-"+ manPerson.getFoot());

        Person womanPerson = pd.constructPerson(new WomanBuilder());
        System.out.println(womanPerson.getBody()+"-"+ womanPerson.getHead()+"-"+ womanPerson.getFoot());
    }
}
