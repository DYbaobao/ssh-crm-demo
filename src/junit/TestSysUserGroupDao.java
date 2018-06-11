package junit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.crm.container.ServiceProvinder;
import com.test.crm.container.ServiceProvinderCore;
import com.test.crm.dao.ISysUserGroupDao;
import com.test.crm.entity.SysUserGroup;

@SuppressWarnings("unused")
public class TestSysUserGroupDao {
    @Test
	public void testSaveSysUserGroupDao(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ISysUserGroupDao iSysUserGroupDao  = (ISysUserGroupDao)context.getBean(ISysUserGroupDao.SERVICE_NAME);
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("��Ӫ��");
		sysUserGroup.setPrincipal("wfg");
		sysUserGroup.setIncumbent("hahaha");
		iSysUserGroupDao.save(sysUserGroup);
	}
    
  
	@Test
    public void testUpdateSysUserGroupDao(){
    
		ISysUserGroupDao iSysUserGroupDao =
	(ISysUserGroupDao)ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
    	SysUserGroup sysUserGroup = new SysUserGroup();
    	sysUserGroup.setId(7);
    	sysUserGroup.setName("haha");
    	sysUserGroup.setIncumbent("uhuh");
    	sysUserGroup.setRemark("hui");
    	sysUserGroup.setPrincipal("daf");
    	iSysUserGroupDao.update(sysUserGroup);
    }
	
	@Test
    public void findSysUserGroupById(){
    
		ISysUserGroupDao iSysUserGroupDao = (ISysUserGroupDao)ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
    	Serializable  id =7;
    	SysUserGroup sysUserGroup = iSysUserGroupDao.findObjectById(id);
    	/*System.out.println(sysUserGroup.getIncumbent());
        System.out.println(sysUserGroup.getName());
    	System.out.println(sysUserGroup.getPrincipal());
    	System.out.println(sysUserGroup.getRemark());
    	System.out.println(sysUserGroup.getId());*/
    }
	
	@Test
	public void deleteByIds(){
		ISysUserGroupDao iSysUserGroupDao = (ISysUserGroupDao)ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
		Serializable [] ids ={7,8,9};
	    iSysUserGroupDao.deleteByIds(ids);
	}
	
	@Test
	public void deleteCollections(){
		ISysUserGroupDao iSysUserGroupDao = (ISysUserGroupDao)ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setId(11);
		SysUserGroup sGroup = new SysUserGroup();
		sGroup.setId(12);
		List<SysUserGroup> list = new ArrayList<SysUserGroup>();
		list.add(sysUserGroup);
		list.add(sGroup);
	    iSysUserGroupDao.deleteAllObjects(list);
	}
	
}
