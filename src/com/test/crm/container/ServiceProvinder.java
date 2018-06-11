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
    		 throw new RuntimeException("您访问的服务名称不能为空");
    	 }
    	 Object bean = null;
    	 //如果spring 容器中包含 beanName
    	 if(sc.context.containsBean(beanName)){
    		 bean= sc.context.getBean(beanName);
    	 }
    	 //如果spring 容器中不包含 beanName
    	 if(bean==null){
    		 throw new RuntimeException("您访问的服务名称【"+beanName+"】不存在");
    	 }
    	 return bean;
     }
}
