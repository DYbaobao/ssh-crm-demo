package com.test.crm.web.action;




import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.crm.container.ServiceProvinder;
import com.test.crm.entity.SysUserGroup;
import com.test.crm.service.ISysUserGroupService;
import com.test.crm.web.form.SysUserGroupForm;

@SuppressWarnings("serial")
public class SysUserGroupAction extends ActionSupport implements ModelDriven<SysUserGroupForm> {
    
     private SysUserGroupForm sysUserGroupForm  = new SysUserGroupForm();
	
	 public String save () throws IllegalAccessException, InvocationTargetException{
		
		
		// ʵ����po����
		 SysUserGroup sysUserGroup = new SysUserGroup();
		 //��ֵvo����po��
//		 BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm); ������spring�İ����ܲ���ֵҪ��org.apache.commons.beanutils.BeanUtils;
		 BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
		 
		 System.out.println(sysUserGroup.getName());
		 //��ȡҵ���Ķ��󣨱���ĿStruts2��spring�Ƿ��� �ģ�
		 ISysUserGroupService iSysUserGroupService  =
				 (ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		 //����po����
		 iSysUserGroupService.saveSysUserGroup(sysUserGroup);
		 return null;	 
     }

	@Override
	public SysUserGroupForm getModel() {
		
		return sysUserGroupForm;
	}
}
