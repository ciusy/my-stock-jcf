package leo.ws.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import leo.entity.WsdocWframework;
import leo.entity.Wsdocument;
import leo.ws.dao.WsDocWFrameworkDao;
import leo.ws.dao.WsDocumentDao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuxiangpan
 * @version ����ʱ�䣺2011-9-23 ����10:35:06
 */
public class TestService {

	WsDocWFrameworkDao wsDocWFrameworkDao;
	WsDocumentDao wsDocumentDao;

	Class<Wsdocument> class1;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		wsDocWFrameworkDao = (WsDocWFrameworkDao) ctx.getBean("wsDocWFrameworkDao");
		wsDocumentDao = (WsDocumentDao) ctx.getBean("wsDocumentDao");
	}

	@Test
	public void testClass() {

		System.out.println(class1.getClass());
		System.out.println(class1.getSimpleName());
	}

	@Test
	public void importData() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=leohis"; // ���ӷ����������ݿ�test
		String userName = "sa"; // Ĭ���û���
		String userPwd = "xuxp"; // ��װsql server 2005ʱ������
		Connection dbConn;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("Connection Successful!"); // ������ӳɹ� ����̨���Connection Successful!

			Statement st = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from MZ_YLWS_MRZ");
			HashSet<String> hs = new HashSet<String>();
			while (rs.next()) {
				hs.add(rs.getString("WSMC"));
			}

			Iterator<String> iterator = hs.iterator();

			Wsdocument wsdocument = null;

			Map<String, Long> map = new HashMap<String, Long>();
			while (iterator.hasNext()) {
				wsdocument = new Wsdocument();
				wsdocument.setDaysOfVisitRemind(-1);
				wsdocument.setDocDescribe("");
				wsdocument.setDocEdition("1");
				String next = iterator.next();
				wsdocument.setDocName(next);
				wsdocument.setDocStore(next);
				wsdocument.setNote("");
				wsdocument.setVisitDocOrNot(false);

				wsDocumentDao.save(wsdocument);
				map.put(next, wsdocument.getDocId());
			}
			rs.beforeFirst();

			WsdocWframework wsdocWframework = null;
			while (rs.next()) {
				wsdocWframework = new WsdocWframework();
				wsdocWframework.setDocId(map.get(rs.getString("WSMC")));
				wsdocWframework.setWitem(rs.getString("KJMC"));
				wsdocWframework.setWscontent(rs.getString("MRZ"));
				wsDocWFrameworkDao.save(wsdocWframework);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
