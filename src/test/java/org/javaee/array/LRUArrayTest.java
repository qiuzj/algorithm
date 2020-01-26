package org.javaee.array;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class LRUArrayTest {

	@Test
	public void test() {
		LRUArray<Integer> list = new LRUArray<>(5);
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int nextInt = random.nextInt(10);
			System.out.println("visit " + nextInt);
			list.visit(nextInt);
			System.out.println(Arrays.toString(list.getData()));
//			print(list.getData());
		}
	}
	

	private void print(Integer[] data) {
		for (int i = data.length - 1; i >= 0; i--) {
			System.out.print(data[i] + " > ");
		}
		System.out.println();
	}
}
