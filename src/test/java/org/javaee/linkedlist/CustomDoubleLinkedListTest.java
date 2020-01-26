package org.javaee.linkedlist;

import org.junit.Test;

public class CustomDoubleLinkedListTest {

	@Test
	public void test() {
		CustomDoubleLinkedList<String> list = new CustomDoubleLinkedList<>();
		list.addHead("h");
		print(list);
		list.addHead("h0");
		print(list);

		list.addTail("t");
		print(list);
		list.addTail("t0");
		print(list);
		
		list.insert(list.getHead(), "h1");
		print(list);
		
		list.insert(list.getTail(), "t1");
		print(list);
		
		System.out.println(list.remove("h").getE());
		print(list);
		
		System.out.println(list.remove("h1").getE());
		print(list);
		
		System.out.println(list.remove("t").getE());
		print(list);
		
		System.out.println(list.removeHead().getE());
		print(list);
		
		System.out.println(list.remove("t1").getE());
		print(list);
		
		System.out.println(list.remove("t0").getE());
		print(list);
	}

	private void print(CustomDoubleLinkedList<String> list) {
		CustomDoubleLinkedList.Node<String> p = list.getHead();
		while (p != null) {
			System.out.print(p.getE() + " > ");
			p = p.getNext();
		}
		System.out.println();
	}
	
}
