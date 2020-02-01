package org.javaee.stack;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class ArrayStackTest {

	@Test
	public void test() {
		ArrayStack<String> stack = new ArrayStack<>(2);
		stack.push("a");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));
		
		stack.push("b");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));

		stack.push("c");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));
		System.out.println("size: " + stack.size());
		
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
		
		stack.push("c");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));
		stack.push("d");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));
		stack.push("e");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));
		stack.push("f");
		System.out.println(String.format("size: %s, data: %s", stack.size(), JSON.toJSON(stack.getData())));
		
		System.out.println(String.format("is empty: %s", stack.isEmpty()));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
	
		System.out.println(String.format("is empty: %s", stack.isEmpty()));
		System.out.println(String.format("pop: %s, size: %s, data: %s", stack.pop(), stack.size(), JSON.toJSON(stack.getData())));
	}
	
}
