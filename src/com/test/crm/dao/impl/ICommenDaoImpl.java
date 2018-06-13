package com.test.crm.dao.impl;



import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.*;

import com.test.crm.dao.ICommenDao;
import com.test.crm.util.GenericClass;




@SuppressWarnings("unused")
public class ICommenDaoImpl<T> extends HibernateDaoSupport implements ICommenDao<T> {
	//获取父类的泛型类型
	@SuppressWarnings("rawtypes")
	private Class entityClass =GenericClass.getGenericClass(this.getClass());

	@Resource(name="sessionFactory")
	public void setSessionFactionDI (SessionFactory sessionFactory){
		//调用父类的setSessionFactory方法,注入sessionFactory
		super.setSessionFactory(sessionFactory);
	}
	/**
	 *  <bean class="com.test.crm.dao.impl.ICommenDaoImpl">
	 <property name="sessionFactory" ref="sessionFactory"></property>
	 </bean>
	 */
	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}


	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public T findObjectById(Serializable id) {
		if(id==null){
			throw new RuntimeException("您要查找的["+id+"]不能为空");
		}
		/**
		 *  getGenericSuperclass()  --泛型反射类 返回类型是type
		 *  ParameterizedType --参数化 的泛型类型
		 *  getActualTypeArguments()---实际的类型
		 */
	 /*   ParameterizedType type =
	    		(ParameterizedType)this.getClass().getGenericSuperclass();
	   @SuppressWarnings("rawtypes")
	   Class entityClass = (Class) type.getActualTypeArguments()[0];*/
		return (T)this.getHibernateTemplate().get(entityClass, id);
	}


	/**
	 * 批量删除,通过多个id删除多个记录
	 */

	@Override
	public void deleteByIds(Serializable... ids) {
		if(ids!=null && ids.length>0){
			for(Serializable  id :ids){
				Object entity = this.getHibernateTemplate().get(entityClass, id);
				if(entity==null){
					throw new RuntimeException("您要查找的["+id+"]不存在");
				}
				this.getHibernateTemplate().delete(entity);
			}
		}

	}


	@Override
	public void deleteAllObjects(Collection<T> entities) {

		this.getHibernateTemplate().deleteAll(entities);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
													final	Object [] params, LinkedHashMap<String, String> orderby) {
		//产生select 语句 select * from SysUserGroup o where
		String hql = "select o from "+entityClass.getSimpleName() +" o where 1=1  ";
		//在select 语句后面组合select 语句的查询条件
		if(StringUtils.isNotBlank(whereHql)){
			hql = hql+whereHql;
		}
		//处理排序
		String orderbyStr = buildOrderby(orderby);
		hql = hql+orderbyStr;
		System.out.println("hql  "+ hql);
		final String fhql =hql;
		List<T> list =(List <T>) this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query =  session.createQuery(fhql);
				setParams(query ,params);
				return query.list();
			}

		});
		return list;
	}
	/*
     * 设置hql 语句所需的参数
     */
	public void setParams(Query query, Object[] params) {
		if(params != null && params.length>0){
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

	}
	public  String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer sbf = new StringBuffer(" ");
		if(orderby!=null && !orderby.isEmpty()){
			sbf.append(" order by  ");
			for (Map.Entry<String, String>  em : orderby.entrySet()) {
				sbf.append(em.getKey()+"  "+em.getValue()+",");

			}
			//去掉最后一个","
			sbf.deleteCharAt(sbf.length()-1);
		}
		return sbf.toString();
	}

}
