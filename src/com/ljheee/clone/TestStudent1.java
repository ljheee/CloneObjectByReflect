package com.ljheee.clone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.ljheee.clone.entity.Student;

/**
 * 反射 中最主要的几个类：Field、Method、Constructor
 * @author ljheee
 *
 */
public class TestStudent1 {

	public static void main(String[] args) {
		
		// Field:属性
		Student stu = new Student();
		Class<?> cls = stu.getClass();
		
		
		// 获得Student类中所有的属性
		Field[] fields = cls.getDeclaredFields();//获取所有声明的字段
		//getFields()  仅 获得public的字段，获取方法也类似
		for (Field f : fields) {
			System.out.println(f.getName() + "\t"
					+ Modifier.toString(f.getModifiers()));
		}
		

		// Method类:方法类
		Method[] ms = cls.getDeclaredMethods();//获得所有声明了的方法
		for (Method method : ms) {
			System.out.println(method.getName());
		}

		try {
			// 固定的方法  	通过  方法名 获得指定的方法
			Method m = cls.getMethod("setAge", new Class<?>[] { int.class });
			m.invoke(stu, new Object[]{21});//动态  调用 方法[该方法是反射--通过方法名获得的]
			
			Method m1 = cls.getMethod("getAge", new Class<?>[] {});
			Object age = m1.invoke(stu, new Object[]{});
			System.out.println(age);
			
			// 获取所有   构造方法
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
