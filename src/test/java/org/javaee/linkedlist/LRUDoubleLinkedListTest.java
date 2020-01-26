package org.javaee.linkedlist;

import java.util.Random;

import org.junit.Test;

public class LRUDoubleLinkedListTest {

	@Test
	public void test() {
		LRUDoubleLinkedList<Integer> list = new LRUDoubleLinkedList<>(5);
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int nextInt = random.nextInt(10);
			System.out.println("visit " + nextInt);
			list.visit(nextInt);
			print(list.getList());
		}
	}
	

	private void print(CustomDoubleLinkedList<?> list) {
		CustomDoubleLinkedList.Node<?> p = list.getHead();
		while (p != null) {
			System.out.print(p.getE() + " > ");
			p = p.getNext();
		}
		System.out.println();
	}
}
