package org.javaee.stack;

import java.util.ArrayList;
import java.util.List;

import org.javaee.bean.SinglyListNode;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class LinkedStackTest {

	@Test
	public void test() {
		LinkedStack<String> stack = new LinkedStack<>();
		stack.push("a");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));
		
		stack.push("b");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));

		stack.push("c");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));
		System.out.println("size: " + stack.size());
		
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
		
		stack.push("c");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));
		stack.push("d");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));
		stack.push("e");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));
		stack.push("f");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(toList(stack.getHead()))));
		
		System.out.println(String.format("is empty: %s", stack.isEmpty()));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
	
		System.out.println(String.format("is empty: %s", stack.isEmpty()));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(toList(stack.getHead()))));
	}
	
	private List<String> toList(SinglyListNode<String> head) {
		List<String> list = new ArrayList<>();
		while (head != null) {
			// 业务逻辑
			list.add(head.getValue());
			// 指针后移
			head = head.getNext();
		}
		return list;
	}
	
}
