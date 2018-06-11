package com.test.crm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import com.test.crm.entity.SysUserGroup;





@SuppressWarnings("unused")
public interface ICommenDao<T> {
   void save(T entity);
   void update(T entity);
    T  findObjectById(Serializable id);
   void deleteByIds(Serializable... ids);
   void deleteAllObjects(Collection<T> entities);
   List<T> findObjectsByConditionWithNoPage(String whereHql,
                                            Object[] params, LinkedHashMap<String, String> orderby);
}
