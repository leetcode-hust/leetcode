package callback;

/**
 * Created by louyuting on 17/1/29.
 */
public class ClientTest {


    public static void main(String[] args) {
        Jiang jiang = new Jiang();

        Lou lou = new Lou(jiang);

        lou.askQuestion("帮我取快递给老师");
    }
}
