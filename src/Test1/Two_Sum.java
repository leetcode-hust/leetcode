package Test1;

public class Two_Sum {

	public static void main(String[] args) {
		int quest[]= new int[]{3,2,4};
		int target=6;		
		twosum_util  two_sum=new twosum_util ();
		int rt[]=two_sum.twoSum(quest, target);
		for (int i = 0; i < rt.length; i++) {
			System.out.print(rt[i]);
		}
					        
	}

}
