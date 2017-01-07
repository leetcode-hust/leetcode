package patterns.factory;

/**
 * 客户端代码
 * @author Administrator
 *
 */
public class Client {
	
	public static void main(String[] args) {

        IFactory addOperation = new AddFactory();
        Operation oper = addOperation.createOperation();

        oper.numberA=11;
        oper.numberB=22;

        double result = oper.getResult();

        System.out.println(result);

	}

}
