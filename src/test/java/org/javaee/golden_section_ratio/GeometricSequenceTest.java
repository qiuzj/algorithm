package org.javaee.golden_section_ratio;

import org.junit.Test;

/**
 * 等比数列
 *  
 * @version
 */
public class GeometricSequenceTest {
	
	/**
	 * 炒股的人有这样的经验，如果每次损失10%，用不了几次就损失一半了，这就是等比数列中每一个数字都在不断按比例衰减的结果。
	 * 具体讲，大约6次，就会损失一半，大约13次就会损失3/4。
	 *  
	 */
	@Test
	public void testDecay() {
		int val = Integer.MAX_VALUE / 100000;
		System.out.print(val);
		while (val > 0) {
			val = (int) (val * 0.9);
			System.out.print("," + val);
		}
	}
	
}
