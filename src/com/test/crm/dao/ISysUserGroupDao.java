package com.test.crm.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.test.crm.entity.SysUserGroup;

@SuppressWarnings("unused")
public interface ISysUserGroupDao extends ICommenDao<SysUserGroup> {
     public final static String SERVICE_NAME = "com.test.crm.dao.impl.SysUserGroupDaoImpl";

}
