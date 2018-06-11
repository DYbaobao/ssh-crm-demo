package com.test.crm.dao.impl;

import org.springframework.stereotype.Repository;

import com.test.crm.dao.ISysUserGroupDao;
import com.test.crm.entity.SysUserGroup;

@Repository(ISysUserGroupDao.SERVICE_NAME)
public class SysUserGroupDaoImpl extends ICommenDaoImpl<SysUserGroup> implements ISysUserGroupDao {

	
}
