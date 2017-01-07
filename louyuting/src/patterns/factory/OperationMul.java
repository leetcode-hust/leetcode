package patterns.factory;

public class OperationMul extends Operation{

	/**
	 * 重写计算方法
	 */
	@Override
	public double getResult() {
		double result = 0.0;
		if (numberB == 0.0){
				try {
					throw new Exception("除数不能为0");
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		result = numberA * numberB;
		return result;
	}
}
