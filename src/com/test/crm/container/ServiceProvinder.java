package com.test.crm.container;

import org.apache.commons.lang.StringUtils;

public class ServiceProvinder {
     private static ServiceProvinderCore sc; 
     static{
    	 sc = new ServiceProvinderCore();
    	 sc.load("beans.xml");
     }
     
     public static Object getService(String beanName){
    	 if(StringUtils.isBlank(beanName)){
    		 throw new RuntimeException("�����ʵķ������Ʋ���Ϊ��");
    	 }
    	 Object bean = null;
    	 //���spring �����а��� beanName
    	 if(sc.context.containsBean(beanName)){
    		 bean= sc.context.getBean(beanName);
    	 }
    	 //���spring �����в����� beanName
    	 if(bean==null){
    		 throw new RuntimeException("�����ʵķ������ơ�"+beanName+"��������");
    	 }
    	 return bean;
     }
}
