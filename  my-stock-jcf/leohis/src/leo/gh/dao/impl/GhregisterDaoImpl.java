package leo.gh.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.Ghregister;
import leo.gh.dao.iface.GhregisterDao;

import org.hibernate.Query;

public class GhregisterDaoImpl extends DaoSupport<Ghregister> implements
		GhregisterDao {

	public boolean addGhregister(Ghregister ghregister) {
		this.getHibernateTemplate().save(ghregister);
		return true;
	}

	public boolean deleteGhregister(Ghregister ghregister) {
		try {
			this.getHibernateTemplate().delete(ghregister);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Ghregister> getAllGhregister() {
		try {
			List<Ghregister> list = this.getHibernateTemplate().find(
					"from Ghregister");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Ghregister getGhregisterByOpnum(String opnum) {
		try {
			Query query = this.getSession().createQuery(
					"from Ghregister g where g.opnum=:opnum");
			query.setString("opnum", opnum);
			if (query.list().size() > 0) {
				return (Ghregister) query.list().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateGhregister(Ghregister ghregister) {
		try {
			this.getHibernateTemplate().update(ghregister);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getMaxopnumByDate(String date) {
		Query query = this
				.getSession()
				.createQuery(
						"select g from Ghregister g where g.opnum like :date order by g.opnum desc");
		query.setString("date", "%" + date + "%");
		List<Ghregister> list = query.list();
		String str = "";
		if (list.size() != 0) {
			str = list.get(0).getOpnum();
		}
		return str;
	}

	public String[][] getGhregisterByCondition(String strDate, String endDate,
			String csName, String mcardNum, String opNum, String cscardNum,int uid) {
		try {
			String[][] str = null;
			if (mcardNum != null && mcardNum != "") {
				String sql = "select gr.opnum,gr.rtid,gr.rpname,gr.expertOrNot,gr.csId,gr.costTypeId,gr.ru,"
						+ "gr.registrar,gr.rtime,gr.rstatus,gr.realPrice,gr.receivablePrice,cs.csname,cs.idcardnum,"
						+ "cs.address,ou.uname "
						+ "from GHRegister gr,GHRegisterType grt,GHCostType gct,CSConsumer cs,CSMedicalCard mc,OSUForm ou "
						+ "where gr.rtid=grt.rtid and gr.rpname<>'��ǰ����' and gr.CostTypeID=gct.id and gr.CsID=cs.csid and mc.CsID=gr.CsID and gr.ru=ou.uid "
						+"and gr.RTime between '"
						+ strDate
						+ "' and '"
						+ endDate + "' and mc.mcardNum='" + mcardNum + "' ";
				if (csName != null && csName != "") {
					sql = sql + "and (cs.csname like'%" + csName + "%' or cs.nameForShort like '%" + csName + "%' ) ";
				}
				if (opNum != null && opNum != "") {
					sql = sql + "and gr.opNum='" + opNum + "' ";
				}
				if (uid != -2) {
					sql = sql + "and gr.ru='"+ uid+ "' ";
				}
				if (cscardNum != null && cscardNum != "") {
					sql = sql + "and cs.idcardNum='" + cscardNum + "' ";
				}
				Query query = this.getSession().createSQLQuery(sql);
				List<Object[]> list = query.list();
				int i = list.size();
				str = new String[i][16];
				for (int y = 0; y < i; y++) {
					str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0]
							.toString();// �����
					str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1]
							.toString();// �Һ�����ID
					str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2]
							.toString();// �Һ���������
					str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3]
							.toString();// �Ƿ���ר��
					str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4]
							.toString();// �������ID
					str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5]
							.toString();// ��������ID
					str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6]
							.toString();// ����ID
					str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7]
							.toString();// �Һ�Ա
					str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8]
							.toString();// �Һ�ʱ��
					str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9]
							.toString();// �Һ�״̬
					str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10]
							.toString();// ʵ�ռ۸�
					str[y][11] = list.get(y)[11] == null ? "" : list.get(y)[11]
							.toString();// Ӧ�ռ۸�
					str[y][12] = list.get(y)[12] == null ? "" : list.get(y)[12]
							.toString();// �����������
					str[y][13] = list.get(y)[13] == null ? "" : list.get(y)[13]
							.toString();// ���֤��
					str[y][14] = list.get(y)[14] == null ? "" : list.get(y)[14]
							.toString();// ��ַ
					str[y][15] = list.get(y)[15] == null ? "" : list.get(y)[15]
							.toString();// ������
				}
			} else {
				String sql = "select gr.opnum,gr.rtid,gr.rpname,gr.expertOrNot,gr.csId,gr.costTypeId,gr.ru,"
						+ "gr.registrar,gr.rtime,gr.rstatus,gr.realPrice,gr.receivablePrice,cs.csname,cs.idcardnum,"
						+ "cs.address,ou.uname "
						+ "from GHRegister gr,GHRegisterType grt,GHCostType gct,CSConsumer cs,OSUForm ou "
						+ "where gr.rtid=grt.rtid and gr.rpname<>'��ǰ����' and gr.CostTypeID=gct.id and gr.CsID=cs.csid and gr.ru=ou.uid "
						+ "and gr.RTime between '"
						+ strDate
						+ "' and '"
						+ endDate + "' ";
				if (csName != null && csName != "") {
					sql = sql + "and (cs.csname like'%" + csName + "%' or cs.nameForShort like '%" + csName + "%' ) ";
				}
				if (opNum != null && opNum != "") {
					sql = sql + "and gr.opNum='" + opNum + "' ";
				}
				if (uid != -2) {
					sql = sql + "and gr.ru='"+ uid+ "' ";
				}
				if (cscardNum != null && cscardNum != "") {
					sql = sql + "and cs.idcardNum='" + cscardNum + "' ";
				}
				Query query = this.getSession().createSQLQuery(sql);
				List<Object[]> list = query.list();
				int i = list.size();
				str = new String[i][16];
				for (int y = 0; y < i; y++) {
					str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0]
							.toString();// �����
					str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1]
							.toString();// �Һ�����ID
					str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2]
							.toString();// �Һ���������
					str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3]
							.toString();// �Ƿ���ר��
					str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4]
							.toString();// �������ID
					str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5]
							.toString();// ��������ID
					str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6]
							.toString();// ����ID
					str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7]
							.toString();// �Һ�Ա
					str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8]
							.toString();// �Һ�ʱ��
					str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9]
							.toString();// �Һ�״̬
					str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10]
							.toString();// ʵ�ռ۸�
					str[y][11] = list.get(y)[11] == null ? "" : list.get(y)[11]
							.toString();// Ӧ�ռ۸�
					str[y][12] = list.get(y)[12] == null ? "" : list.get(y)[12]
							.toString();// �����������
					str[y][13] = list.get(y)[13] == null ? "" : list.get(y)[13]
							.toString();// ���֤��
					str[y][14] = list.get(y)[14] == null ? "" : list.get(y)[14]
							.toString();// ��ַ
					str[y][15] = list.get(y)[15] == null ? "" : list.get(y)[15]
							.toString();// ������
				}
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[][] getGhregisterByDateandRstatus(String stdate,
			String eddate, String rstatus,int uid) {
		try {
			String sql = "select cc.costTypeId,cc.csId,cc.expertOrNot,cc.opnum,cc.realPrice,cc.receivablePrice,cc.registrar,cc.rstatus,cc.rtid,cc.rtime,cc.ru,cc.sid,cc.rpname from Ghregister cc where  cc.rpname<>'��ǰ����' and cc.rstatus='"
					+ rstatus
					+ "' and cc.ru='"
					+ uid
					+ "' and cc.rtime between '"
					+ stdate
					+ "' and '"
					+ eddate + "' ";

			Query query = this.getSession().createSQLQuery(sql);

			List<Object[]> list = query.list();
			int i = list.size();
			String[][] str = new String[i][13];
			for (int y = 0; y < i; y++) {
				str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0]
						.toString();// ��������ID
				str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1]
						.toString();// �������ID
				str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2]
						.toString();// �Ƿ���ר�Һ�
				str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3]
						.toString();// �����
				str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4]
						.toString();// ʵ��
				str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5]
						.toString();// Ӧ��
				str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6]
						.toString();// �Һ�Ա
				str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7]
						.toString();// �Һ�״̬
				str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8]
						.toString();// �Һ�����ID
				str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9]
						.toString();// �Һ�ʱ��
				str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10]
						.toString();// �Һſ���
				str[y][11] = list.get(y)[11] == null ? "" : list.get(y)[11]
						.toString();// Ա��ID
				str[y][12] = list.get(y)[12] == null ? "" : list.get(y)[12]
						.toString();// �Һ�����

			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[][] getGhregisterDZ(String Date_B, String Date_e, String XingMing, String XingMingSuoXie, Integer YiLiaoJiGou){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		Query query = null;

		if (Date_B != null && !Date_B.equals("")) {
			tj = "GHRegister.RTime >= ? and GHRegister.RTime <= ?"; // �Һ�����
			cs.add(Date_B);
			cs.add(Date_e);
		}
		if (XingMing != null && !XingMing.equals("")) { // ����
			if (tj.equals(""))
				tj = " CSConsumer.CSName like ?";
			else
				tj = tj + " and CSConsumer.CSName like ?";
			cs.add("%" + XingMing + "%");
		}
		if (XingMingSuoXie != null && !XingMingSuoXie.equals("")) { // ������д
			if (tj.equals(""))
				tj = " CSConsumer.NameForShort like ?";
			else
				tj = tj + " and CSConsumer.NameForShort like ?";
			cs.add("%" + XingMingSuoXie + "%");
		}
		if (YiLiaoJiGou != -2) { // ҽ�ƻ���ID
			if (tj.equals(""))
				tj = " GHRegisterType.MedicalInstID = ?";
			else
				tj = tj + " and GHRegisterType.MedicalInstID = ?";
			cs.add(YiLiaoJiGou);
		}
		query = this
				.getSession()
				.createSQLQuery("select " +
						        "  CSConsumer.CSName, " + //0����
						        "  CSConsumer.Sex, " + //1�Ա�
						        "  CSConsumer.Birthday, " + //2��������
						        "  CSConsumer.Address, " + //3סַ
						        "  CSConsumer.IDCardNum, " + //4���֤��
						        "  CSConsumer.Cellphone, " + //5�ֻ�
						        "  CSConsumer.Telephone, " + //6�绰
						        "  CSConsumer.CsID " + //7�������ID
						        "from GHRegister,CSConsumer,GHRegisterType " +
						        "where " +
						        "  GHRegister.CsID = CSConsumer.CsID and " +
						        "  GHRegisterType.RTID = GHRegister.RTID and " + tj);
			for (int i = 0; i < cs.size(); i++) {
				query.setParameter(i, cs.get(i));
			}	
		query.list();
		return listObject2StringString(query.list());
		
	}
	
	public List<Ghregister> getGhregisterfortg(long sid,String stdate,String eddate) throws Exception{ 
	Query query = this
	.getSession()
	.createQuery(
			"from Ghregister  where (rtime between ? and ?) and registrar=? and rtid<>-1 order by rtime desc");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    query.setDate(0, format.parse(stdate));
    query.setDate(1, format.parse(eddate));
    query.setLong(2, sid);
    List<Ghregister> list= query.list();
    if(list.size()>0){
    	return list;
    }
    return null;
	}
	
}
