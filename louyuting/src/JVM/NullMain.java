package JVM;

/**
 * Created by louyuting on 17/1/2.
 */
class Parent {
    public static int A=1;
    static {
        System.out.println(A);
        A=2;
    }
}

class Sub extends Parent{
    public static int B = A;
}

public class NullMain {
    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
