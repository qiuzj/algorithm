package org.javaee.recursion;

import org.junit.Test;

/**
 * 走台阶，每次可走1或2个台阶，共几种走法
 *
 */
public class WalkStepsTest {

	@Test
	public void test() {
		System.out.println(recursive(10));
		System.out.println(loop(10));
	}
	
	/**
	 * 递推公式：f(n) = f(n-1) + f(n-2) （n>=3）
	 * 终止条件：f(1)=1, f(2)=2 （n=1或n=2）
	 * 
	 * @param n
	 * @return
	 */
	public int recursive(int n) {
		if (n <= 2) {
			return n;
		}
		return recursive(n - 1) + recursive(n - 2);
	}

	/**
	 * 循环实现
	 * 
	 * @param n
	 * @return
	 */
	public int loop(int n) {
		if (n <= 2) {
			return n;
		}
		int n1 = 1;
		int n2 = 2;
		int ret = -1;
		for (int i = 3; i <= n; i++) {
			ret = n1 + n2;
			n1 = n2;
			n2 = ret;
		}
		return ret;
	}
	
}
