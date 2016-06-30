package com.ljheee.clone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static Object copyObject(Object srcObject) {
		// 获取源对象类型
		Class<?> cls = srcObject.getClass();
		Object newObject = null;
		// 获取源对象构造方法
		try {
			Constructor<?> con = cls.getConstructor();
			// 通过构造方法实例化一个对象
			newObject = con.newInstance();
			// 获取源对象的属性(name,age,address)
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				String setMethod = "set"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1);
				String getMethod = "get"
						+ f.getName().substring(0, 1).toUpperCase()
						+ f.getName().substring(1);
				// 根据get方法的名字获取方法
				Method getName = cls.getMethod(getMethod);
				Method setName = cls.getMethod(setMethod, new Class[] { f
						.getType() });

				Object value = getName.invoke(srcObject, new Object[] {});
				setName.invoke(newObject, new Object[] { value });
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newObject;
	}

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setName("zhangsan");
		student1.setAge(22);
		student1.setAddress("湖南长沙");

		Student newStudent = (Student) copyObject(student1);
		System.out.println(newStudent.getName() + "\t" + newStudent.getAge()
				+ "\t" + newStudent.getAddress());
		
		Person person = new Person();
		person.setId(21);
		person.setName("admin");
		person.setSex("女");
		Person newPerson = (Person)copyObject(person);
		System.out.println(newPerson.getId()+"\t"+newPerson.getSex());
	}

}
