package algorithm.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PopMaxNum {

	public Stack<Integer> stack = new Stack<Integer>();
	public Stack<Integer> stack2 = new Stack<Integer>();
	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void push(Integer num) {
		stack.push(num);
		if (stack2.isEmpty()) {
			stack2.push(num);
			map.put(num, 1);
		} else {
			if (num > stack2.peek()) {
				stack2.push(num);
				if (!map.containsKey(num)) {
					map.put(num, 1);
					return;
				}
			}
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
		}
	}

	public int popMaxNum() {
		int temp = stack.pop();
		if (map.containsKey(temp)) {
			map.put(temp, map.get(temp) - 1);
		}
		int temp2 = stack2.peek();
		if (map.get(temp2) == 0) {
			return stack2.pop();
		} else {
			return temp2;
		}
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		PopMaxNum pmn = new PopMaxNum();
		pmn.push(0);
		pmn.push(1);
		pmn.push(4);
		pmn.push(4);
		pmn.push(5);
		pmn.push(4);
		pmn.push(5);
		
		while (!pmn.isEmpty()) {
			System.out.println("current max : " + pmn.popMaxNum());
		}
	}
}
