package org.javaee.array;

import java.util.Random;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class CustomArrayTest {

	@Test
	public void test() {
		CustomArray array = new CustomArray(2);
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			array.add(random.nextInt(100));
		}
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.add(200);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.insert(5, 2);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.delete(3);
		System.out.println(JSON.toJSONString(array.getData()));
		
		System.out.println("---");
		array.insert(66, array.getSize());
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.insert(33, 0);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.delete(array.getSize() - 1);
		System.out.println(JSON.toJSONString(array.getData()));
		
		array.delete(0);
		System.out.println(JSON.toJSONString(array.getData()));
	}
	
}
