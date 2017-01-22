package com.pervez.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;


public  class SetEntityByModel<V, T> {
	
	public static void main(String args[]) throws Exception{
		
		
		
		SetEntityByModel<FromClass,ToClass> model = new SetEntityByModel<FromClass,ToClass>();
		
		FromClass fromClass = new FromClass();
		
		fromClass.setId(1);
		fromClass.setName("Pervez");
		fromClass.setDob(new Date());
		
		ToClass toClass = model.setFields(fromClass, ToClass.class);
		System.out.println(toClass.getId());
		System.out.println(toClass.getName());
		System.out.println(toClass.getDob());
		
	}
	

	
	public T setFields(V v, Class<T> c) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
	
		T t =c.newInstance();
		
		Field[]fields =   v.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    System.out.println(nameCapitalized);
			    
			    Method m = t.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = v.getClass().getMethod("get"+nameCapitalized, null);
			    System.out.println(method.invoke(v, null));
				m.invoke(t, method.invoke(v, null));
			}catch(Exception e){
				
			}
		}
		
		return t;
		
	}
	
	
	
}
