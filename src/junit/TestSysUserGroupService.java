package junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.crm.container.ServiceProvinder;
import com.test.crm.entity.SysUserGroup;
import com.test.crm.service.ISysUserGroupService;

public class TestSysUserGroupService {
	
	@Test
    public void testSaveSysUserGroup(){
  	   
  	    ISysUserGroupService iSysUserGroupService  = (ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
  		SysUserGroup sysUserGroup = new SysUserGroup();
  		sysUserGroup.setName("��ed��");
  		sysUserGroup.setPrincipal("zsh");
  		sysUserGroup.setIncumbent("cry");
  		iSysUserGroupService.saveSysUserGroup(sysUserGroup);
  	    
    }
	  @Test
      public void testSaveSysUserGroupS(){
    	    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	    ISysUserGroupService iSysUserGroupService  = (ISysUserGroupService)context.getBean(ISysUserGroupService.SERVICE_NAME);
    		SysUserGroup sysUserGroup = new SysUserGroup();
    		sysUserGroup.setName("��ά��");
    		sysUserGroup.setPrincipal("zsh");
    		sysUserGroup.setIncumbent("cry");
    		iSysUserGroupService.saveSysUserGroup(sysUserGroup);
    	    
      }
	  
	  @Test
	  public void findObjectsByConditionWithNoPage(){
		   ISysUserGroupService  iSysUserGroupService = (ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		   
		   //��ȡ���ŵ�����
		     String name = "��Ӫ��";
		   //��ȡ���ŵĸ�����
		     String principal ="wfg";
		     List<SysUserGroup> list =  iSysUserGroupService.findSysUserGroups(name,principal);
		     System.out.println(list.size());
	  }
	  
	  
}
