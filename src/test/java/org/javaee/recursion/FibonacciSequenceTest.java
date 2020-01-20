package org.javaee.recursion;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 斐波那契数列
 *
 */
public class FibonacciSequenceTest {
	
	private static Map<Long, Long> cacheMap;
	
	static {
		cacheMap = new HashMap<>();
		cacheMap.put(1L, 1L);
		cacheMap.put(2L, 1L);
	}
	
	@Test
	public void testRecursiveFibonacci() {
		System.out.println(recursiveFibonacci(40)); // 重复计算，超级慢
		System.out.println(recursiveFibonacciWithCache(100));
		System.out.println(loop(100));
	}
	
	/**
	 * 递推公式：f(n) = f(n-1) + f(n-2);（n>=3）
	 * 终止条件：f(1) = 1, f(2) = 1。（n=1或n=2）
	 */
	public long recursiveFibonacci(long n) {
		if (n <= 2) return 1;
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}

	/**
	 * 防止重复计算，已计算过的结果缓存到Map中
	 * 
	 * @param n
	 * @return
	 */
	public long recursiveFibonacciWithCache(long n) {
		if (n <= 2) return 1;
		
		if (cacheMap.containsKey(n)) {
			System.out.println("containsKey n");
			return cacheMap.get(n);
		}
		
		long c1 = n - 1;
		long n1 = -1;
		if (cacheMap.containsKey(c1)) {
			System.out.println("containsKey n-1");
			n1 = cacheMap.get(c1);
		} else {
			n1 = recursiveFibonacciWithCache(c1);
			cacheMap.put(c1, n1);
		}

		long c2 = n - 2;
		long n2 = -1;
		if (cacheMap.containsKey(c2)) {
			System.out.println("containsKey n-2");
			n2 = cacheMap.get(c2);
		} else {
			n2 = recursiveFibonacciWithCache(c2);
			cacheMap.put(c2, n2);
		}
		
		return n1 + n2;
	}
	
	/**
	 * 循环实现
	 * 
	 * @param n
	 * @return
	 */
	public long loop(long n) {
		if (n <= 2) return 1;
		long n1 = 1;
		long n2 = 1;
		long cur = -1;
		for (long i = 3; i <= n; i++) {
			cur = n1 + n2;
			n1 = n2;
			n2 = cur;
		}
		return cur;
	}

}
