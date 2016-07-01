package com.ljheee.clone;

import com.ljheee.clone.entity.Student;

/**
 * ��ʾ3�ӷ�ʽ--�����
 * ע�⣺��������д����---����+����
 * @author ljheee
 *
 */
public class TestStudent {

	public static void main(String[] args) {

		try {
			//1��ʽ--Class.forName("����")
			Class<?> cls1 = Class.forName("com.ljheee.clone.entity.Student");
			
			//2��ʽ--����.class
			Class<?> cls2 = Student.class;
			
			//3��ʽ--����.getClass()
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
