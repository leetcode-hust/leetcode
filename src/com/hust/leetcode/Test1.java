package com.hust.leetcode;


/**
 * @author ALKL
 *
 */
public class Test1 {

	public static void main(String[] args) {
		int quest[]= new int[]{3,2,4};
		int target=6;		
		Two_sum two_sum=new Two_sum();
		int rt[]=two_sum.twoSum(quest, target);
		for (int i = 0; i < rt.length; i++) {
			System.out.print(rt[i]);
		}
					        
	}
}
