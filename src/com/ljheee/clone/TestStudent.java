package com.ljheee.clone;

public class TestStudent {

	public static void main(String[] args) {

		try {
			//1
			Class<?> cls1 = Class.forName("com.newer.cn.Student");
			
			//2
			Class<?> cls2 = Student.class;
			
			//3
			Student stu = new Student();
			Class<?> cls3 = stu.getClass();
			
			Class<?> cls4 = Class.forName("java.lang.String");
			System.out.println(cls1.getName());
			System.out.println(cls2.getName());
			System.out.println(cls3.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
