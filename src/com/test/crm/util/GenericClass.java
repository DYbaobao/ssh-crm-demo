package com.test.crm.util;

import java.lang.reflect.ParameterizedType;
/**********************************************************
 获取父类的泛型类型
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
