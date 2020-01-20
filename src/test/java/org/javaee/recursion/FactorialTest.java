package org.javaee.recursion;

import org.junit.Test;

/**
 * 阶乘
 *
 */
public class FactorialTest {
	
	@Test
	public void testFactorial() {
		System.out.println(recursiveFactorial(5));
		System.out.println(loop(5));
	}
	
	/**
	 * 递推公式：f(n) = f(n-1) * n;（n>=2）
	 * 终止条件：f(1) = 1。（n=1）
	 */
	public int recursiveFactorial(int n) {
		if (n == 1) return 1;
		return recursiveFactorial(n - 1) * n;
	}

	/**
	 * 循环实现
	 * 
	 * @param n
	 * @return
	 */
	public int loop(int n) {
		if (n == 1) return 1;
		int cur = 1;
		for (int i = 2; i <= n; i++) {
			cur = cur * i;
		}
		return cur;
	}

}
