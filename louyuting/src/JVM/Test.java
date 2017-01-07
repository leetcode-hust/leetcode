package JVM;

/**
 * Created by louyuting on 17/1/2.
 */
class SuperClass
{
    public static int value = 123;

    static
    {
        System.out.println("SuperClass init");
    }
}

class SubClass extends SuperClass
{
    static
    {
        System.out.println("SubClass init");
    }
}
public class Test {
    public static void main(String[] args)
    {
        System.out.println(SubClass.value);
    }
}
