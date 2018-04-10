package com.pervez.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class SetEntityByModel{
	
	

	
	public static <V, T> T setFields(V fromEntity, Class<T> toEntity) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
	
		T t =toEntity.newInstance();
		
		Field[]fields =   fromEntity.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    System.out.println(nameCapitalized);
			    
			    Method m = t.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = fromEntity.getClass().getMethod("get"+nameCapitalized, null);
			    System.out.println(method.invoke(fromEntity, null));
				m.invoke(t, method.invoke(fromEntity, null));
			}catch(Exception e){
				
			}
		}
		
		return t;
		
	}
	/**
		Ignore all null values.
	*/
	public static <V,T> T setFields(V fromEntity, T toEntity) throws Exception{
		
		//T t =c.newInstance();
		
		Field[]fields =   fromEntity.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    
			    Method m = toEntity.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = fromEntity.getClass().getMethod("get"+nameCapitalized, null);
			    Object b = method.invoke(fromEntity, null);
			    if(b!=null){
			    	m.invoke(toEntity, b);
			    }
			    
			}catch(Exception e){
				
			}
		}
		
		return toEntity;
		
	}
	
	public static <V,T> T setSelecetedFields(V fromEntity, Class<T> toEntity, String...selectedFields )  throws Exception{
		
		T t =toEntity.newInstance();
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(selectedFields));
		Field[]fields =   fromEntity.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				boolean b = arrayList.contains(field.getName());
				
				if(b){
				
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    
			    Method m = t.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = fromEntity.getClass().getMethod("get"+nameCapitalized, null);
			    m.invoke(t, method.invoke(fromEntity, null));
				}
			}catch(Exception e){
				
			}
		}
		
		return t;
	}
	
	public static <T,V> T setSelecetedFields(V fromEntity, T toEntty, String...selectedFields )  throws Exception{
		
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(selectedFields));
		Field[]fields =   fromEntity.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				boolean b = arrayList.contains(field.getName());
				
				if(b){
				
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    
			    Method m = toEntty.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = fromEntity.getClass().getMethod("get"+nameCapitalized, null);
			    m.invoke(toEntty, method.invoke(fromEntity, null));
				}
			}catch(Exception e){
				
			}
		}
		
		return toEntty;
	}
	
	public static <V,T> T setFieldsWithoutIgnoredFields(V fromEntity, Class<T> toEntity, String...ingnoredFields )  throws Exception{
		
		T t =toEntity.newInstance();
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(ingnoredFields));
		Field[]fields =   fromEntity.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				boolean b = arrayList.contains(field.getName());
				
				if(!b){
				
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    
			    Method m = t.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = fromEntity.getClass().getMethod("get"+nameCapitalized, null);
			    m.invoke(t, method.invoke(fromEntity, null));
				}
			}catch(Exception e){
				
			}
		}
		
		return t;
	}
	
	
	public static <V,T> T setFieldsWithoutIgnoredFields(V fromEntity, T toEntity, String...ingnoredFields )  throws Exception{
		
		
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(ingnoredFields));
		Field[]fields =   fromEntity.getClass().getDeclaredFields();
		for(Field field: fields){
			try{
				boolean b = arrayList.contains(field.getName());
				
				if(!b){
				
				String s1 = field.getName().substring(0, 1).toUpperCase();
			    String nameCapitalized = s1 + field.getName().substring(1);
			    
			    Method m = toEntity.getClass().getDeclaredMethod("set"+nameCapitalized,field.getType());
			    
			    Method method = fromEntity.getClass().getMethod("get"+nameCapitalized, null);
			    m.invoke(toEntity, method.invoke(fromEntity, null));
				}
			}catch(Exception e){
				
			}
		}
		
		return toEntity;
	}
	
	
}
