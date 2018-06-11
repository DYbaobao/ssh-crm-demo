package com.test.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.crm.dao.ISysUserGroupDao;
import com.test.crm.entity.SysUserGroup;
import com.test.crm.service.ISysUserGroupService;

@Transactional(readOnly=true)
@Service(ISysUserGroupService.SERVICE_NAME)
public class SysUserGroupServiceImpl implements ISysUserGroupService {
    
	@Resource(name=ISysUserGroupDao.SERVICE_NAME)
	private ISysUserGroupDao iSysUserGroupDao;

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveSysUserGroup(SysUserGroup sysUserGroup) {
	
		iSysUserGroupDao.save(sysUserGroup);
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@Override
	public List<SysUserGroup> findSysUserGroups(String name, String principal) {
		 //获取部门的名称
	     name = "运营部";
	     //获取部门的负责人
	     principal ="wfg";
	     //组织hql语句
	     //封装查询的条件
	     String whereHql = " ";
	     //封装查询所需要的参数
	     List paramsList = new ArrayList<>();
	     if(StringUtils.isNotBlank(name)){
	    	 whereHql = " and o.name LIKE ? ";
	    	 paramsList.add("%"+name+"%");
	     }
	     if(StringUtils.isNotBlank(principal)){
	    	 whereHql += " and o.principal = ? ";
	    	 paramsList.add(principal);
	     }	
	     Object[]  params = paramsList.toArray();
	     //组织排序
	     LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
	     orderby.put("o.id", "asc");
	     orderby.put("o.name", "desc");
	     List<SysUserGroup> list = iSysUserGroupDao.findObjectsByConditionWithNoPage(whereHql,params,orderby);
		return list;
	}

}
