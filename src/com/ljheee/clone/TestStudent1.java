package com.ljheee.clone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.ljheee.clone.entity.Student;

/**
 * ���� ������Ҫ�ļ����ࣺField��Method��Constructor
 * @author ljheee
 *
 */
public class TestStudent1 {

	public static void main(String[] args) {
		
		// Field:����
		Student stu = new Student();
		Class<?> cls = stu.getClass();
		
		
		// ���Student�������е�����
		Field[] fields = cls.getDeclaredFields();//��ȡ�����������ֶ�
		//getFields()  �� ���public���ֶΣ���ȡ����Ҳ����
		for (Field f : fields) {
			System.out.println(f.getName() + "\t"
					+ Modifier.toString(f.getModifiers()));
		}
		

		// Method��:������
		Method[] ms = cls.getDeclaredMethods();//������������˵ķ���
		for (Method method : ms) {
			System.out.println(method.getName());
		}

		try {
			// �̶��ķ���  	ͨ��  ������ ���ָ���ķ���
			Method m = cls.getMethod("setAge", new Class<?>[] { int.class });
			m.invoke(stu, new Object[]{21});//��̬  ���� ����[�÷����Ƿ���--ͨ����������õ�]
			
			Method m1 = cls.getMethod("getAge", new Class<?>[] {});
			Object age = m1.invoke(stu, new Object[]{});
			System.out.println(age);
			
			// ��ȡ����   ���췽��
			Constructor[] cons = cls.getConstructors();
			for(Constructor c : cons){
				System.out.println(c.getName());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
