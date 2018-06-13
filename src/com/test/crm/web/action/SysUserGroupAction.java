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


		// 实例化po对象
		SysUserGroup sysUserGroup = new SysUserGroup();
		//赋值vo对象到po中
//		 BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm); 导入了spring的包不能插入值要导org.apache.commons.beanutils.BeanUtils;
		BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);

		System.out.println(sysUserGroup.getName());
		//获取业务层的对象（本项目Struts2和spring是分离 的）
		ISysUserGroupService iSysUserGroupService  =
				(ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		//保存po对象
		iSysUserGroupService.saveSysUserGroup(sysUserGroup);
		return null;
	}

	@Override
	public SysUserGroupForm getModel() {

		return sysUserGroupForm;
	}
}
