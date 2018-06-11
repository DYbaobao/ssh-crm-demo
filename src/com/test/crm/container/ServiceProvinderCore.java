package com.test.crm.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProvinderCore {
     protected ApplicationContext  context;
     
     public void load(String filename){
    	 context = new ClassPathXmlApplicationContext(filename);
     }
}
