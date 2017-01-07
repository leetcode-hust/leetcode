package JVM;

/**
 * Created by louyuting on 17/1/1.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e){
            System.out.print("stack length :" + oom.stackLength);
            throw e;
        }
    }
}
