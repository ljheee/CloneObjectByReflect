package com.ljheee.clone;

import com.ljheee.clone.entity.Student;

/**
 * 演示3钟方式--获得类
 * 注意：类名完整写法是---包名+类名
 * @author ljheee
 *
 */
public class TestStudent {

	public static void main(String[] args) {

		try {
			//1方式--Class.forName("类名")
			Class<?> cls1 = Class.forName("com.ljheee.clone.entity.Student");
			
			//2方式--类名.class
			Class<?> cls2 = Student.class;
			
			//3方式--对象.getClass()
			Student stu = new Student();
			Class<?> cls3 = stu.getClass();
			
			Class<?> cls4 = Class.forName("java.lang.String");
			
			System.out.println(cls1.getName());
			System.out.println(cls2.getName());
			System.out.println(cls3.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
