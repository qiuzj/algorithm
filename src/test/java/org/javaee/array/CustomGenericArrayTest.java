package org.javaee.array;

import java.util.Random;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class CustomGenericArrayTest {

	@Test
	public void test() {
		CustomGenericArray<Integer> array = new CustomGenericArray<>(2);
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			array.add(random.nextInt(100));
		}
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.add(200);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.insert(2, 5);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.remove(3);
		System.out.println(JSON.toJSONString(array.getData()));
		
		System.out.println("---");
		array.insert(array.getSize(), 66);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.insert(0, 33);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.remove(array.getSize() - 1);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.remove(0);
		System.out.println(JSON.toJSONString(array.getData()));
		
		System.out.println("---");
		
		array.removeFirst();
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.removeLast();
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.addFirst(1);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.addLast(300);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.set(1, 33);
		System.out.println(JSON.toJSONString(array.getData()));
		
		System.out.println(array.isEmpty());
		System.out.println(array.getSize());
		
		System.out.println(array.contains(8));
		System.out.println(array.contains(array.get(3)));

		System.out.println(array.find(9));
		System.out.println(array.find(array.get(4)));
	}
	
}
