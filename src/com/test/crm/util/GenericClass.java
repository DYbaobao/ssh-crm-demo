package com.test.crm.util;

import java.lang.reflect.ParameterizedType;
/**********************************************************
   ��ȡ����ķ�������
 *******************************************************
 */
public class GenericClass {
	@SuppressWarnings("rawtypes")
	public static Class getGenericClass( Class clazz) {
		   ParameterizedType type =
		    		(ParameterizedType)clazz.getGenericSuperclass();
		   Class entityClass = (Class) type.getActualTypeArguments()[0];
		return entityClass;
	}

}
