package org.javaee.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HashDistributionTester {
	/**
	 * 将整个哈希空间等分成64份，统计每个空间内的哈希值数量
	 * 
	 * @param hashs
	 */
	public static Map<Integer, Integer> partition(List<Integer> hashs) {
		// step = 2^32 / 64 = 2^26
		final int step = 33554432;
		List<Integer> nums = new ArrayList<>();
		Map<Integer, Integer> statistics = new LinkedHashMap<>();
		int start = 0;
		for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += step) {
			final long min = i;
			final long max = min + step;
			int num = (int) hashs.parallelStream().filter(x -> x >= min && x < max).count();

			statistics.put(start++, num);
			nums.add(num);
		}

		// 为了防止计算出错，这里验证一下
		int hashNum = nums.stream().reduce((x, y) -> x + y).get();
		assert hashNum == hashs.size();

		return statistics;
	}
}
