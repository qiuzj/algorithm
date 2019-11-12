package org.javaee.golden_section_ratio;

/**
 * 斐波那契数列.
 * 每1个数都是前2个数之和，每1个数与前1个数的的比值近似1.618（黄金分割比例），越到后面增长越快。
 * 除了最开始的几个数字之外，后续的数字最终的走向是收敛于黄金分割的比例。
 *  
 * @version
 */
public class FibonacciSequenceTest {

	public static void main(String[] args) {
		long prevs = 0; // 前1个数
		long current = 1; // 当前数
		for (int i = 1; ; i++) {
			if (i == 1) {
				System.out.println(String.format("第%s个数：%s，与前一个数的相比：%s", i, current, "无"));
			} else {
				System.out.println(String.format("第%s个数：%s，与前一个数的相比：%s", i, current, (float)(current)/prevs));
			}
			
			long next = prevs + current; // 下一个数
			prevs = current; // 更新前一个数为当前数
			current = next; // 更新当前数为下一个数
			
			if (next < 0) {
				break;
			}
		}
	}

}
