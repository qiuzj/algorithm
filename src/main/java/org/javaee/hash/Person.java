package org.javaee.hash;

public class Person {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person p = new Person("qiuzj");
		System.out.println(p.hashCode());
		System.out.println(System.identityHashCode(p));
		p = new Person("qiuzj2");
		System.out.println(p.hashCode());
		System.out.println(System.identityHashCode(p));
		
		String str1 = new String("abc");
	    String str2 = new String("abc");
	    System.out.println("str1 hashCode: " + str1.hashCode());
	    System.out.println("str2 hashCode: " + str2.hashCode());
	    System.out.println("str1 identityHashCode: " + System.identityHashCode(str1));
	    System.out.println("str2 identityHashCode: " + System.identityHashCode(str2));
	}
	
}
