package org.javaee.hash;

public class Time33UtilsTester {

	public static void main(String[] args) {
		String[] array = {"qiuzhanjia", "中华人民共和国", "qiuzhanjia中华人民共和国"};
		for (String value : array) {
			System.out.print(Time33Utils.time33V1(value));
			System.out.print(" ");
			System.out.print(Time33Utils.time33V2(value));
			System.out.print(" ");
			System.out.print(Time33Utils.time33V3(value));
			
			System.out.print(" ");
			System.out.print(Time33Utils.time31V1(value));
			System.out.print(" ");
			System.out.println(Time33Utils.time31V2(value));
		}
	}
	
}
