package com.test.crm.service;

import java.util.List;

import com.test.crm.entity.SysUserGroup;

public interface ISysUserGroupService {
	public final static String SERVICE_NAME = "com.test.crm.service.impl.SysUserGroupServiceImpl";
	
	public void saveSysUserGroup(SysUserGroup sysUserGroup);

	public List<SysUserGroup> findSysUserGroups(String name, String principal);
}
