package junit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.test.crm.entity.SysUserGroup;

public class TestHibernate {
   
	@Test
	public void testHibernateConf() {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx =s.beginTransaction();
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("œ˙ €≤ø");
		sysUserGroup.setPrincipal("xxxxxx");
		sysUserGroup.setIncumbent("sdf");
		s.save(sysUserGroup);
		tx.commit();
		s.close();
	}
}
