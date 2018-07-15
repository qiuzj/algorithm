package org.javaee.hash;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class HashConflictTester2 {

	@Test
	public void testConflictRate() throws IOException {
		// read file
		InputStream is = HashConflictTester2.class.getClassLoader().getResourceAsStream("org/javaee/hash/linux.words");
		List<String> lines = IOUtils.readLines(is, "UTF-8");
		
		System.out.println("hash");
		computeConflictRate(lines, 2);
	}

	/**
	 * 计算冲突率
	 * 
	 * @param lines
	 */
	private void computeConflictRate(List<String> lines, int multiplier) {
		List<Integer> hashList = computeHashes(lines, multiplier);
		hashList.forEach(x -> System.out.println(x));
	}
	
	/**
	 * compute hashes
	 * 
	 * @param lines
	 * @param multiplier
	 * @return
	 */
	private List<Integer> computeHashes(List<String> lines, int multiplier) {
		Function<String, Integer> hashFunction = x -> {
			int hash = 0;
			if (multiplier == 31) {
				hash = Time33Utils.time31V2(x);
			} else {
				for (int i = 0; i < x.length(); i++) {
					hash = (hash * multiplier) + x.charAt(i);
				}
			}
			return hash;
		};
		return lines.parallelStream().map(hashFunction).collect(Collectors.toList());
	}
	
}
