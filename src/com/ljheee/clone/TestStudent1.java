package com.ljheee.clone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestStudent1 {

	public static void main(String[] args) {
		// Field:属性
		Student stu = new Student();
		Class<?> cls = stu.getClass();
		// 获得Student类中所有的属性
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName() + "\t"
					+ Modifier.toString(f.getModifiers()));
		}

		// Method类:方法类
		Method[] ms = cls.getDeclaredMethods();
		for (Method method : ms) {
			System.out.println(method.getName());
		}

		try {
			// 固定的方法
			Method m = cls.getMethod("setAge", new Class<?>[] { int.class });
			m.invoke(stu, new Object[]{21});
			
			Method m1 = cls.getMethod("getAge", new Class<?>[] {});
			Object age = m1.invoke(stu, new Object[]{});
			System.out.println(age);
			
			//构造方法
			Constructor[] cons = cls.getConstructors();
			for(Constructor c : cons){
				System.out.println(c.getName());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
