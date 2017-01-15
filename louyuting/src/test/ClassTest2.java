package test;

/**
 * Created by louyuting on 17/1/15.
 */
class Second{
    static {
        System.out.println("Loading Second");
    }
}

class Third{
    static {
        System.out.println("Loading Third");
    }
}

public class ClassTest2 {
    public static void main(String[] args) {
        try {
            Class secondA = Class.forName("test.Second");
            secondA = Third.class;
            Class<Second> SecondB = (Class<Second>) Class.forName("test.Second");
            //SecondB = Third.class;//error
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void test1(){
        try {
            Class<?> secondA = Class.forName("test.Second");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
