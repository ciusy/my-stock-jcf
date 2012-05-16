package leo.cs.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.cs.dao.iface.CsconsumerDao;
import leo.entity.Csconsumer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mortbay.log.Log;
import org.springframework.dao.DataAccessResourceFailureException;

public class CsconsumerDaoImpl extends DaoSupport<Csconsumer> implements CsconsumerDao {

	public Csconsumer getCInfoById(Long id) {
		try{
		return (Csconsumer) getHibernateTemplate().get(Csconsumer.class, id);
		}catch (Exception e){
			e.printStackTrace();
		}return null;
	}

	public Boolean addCsconsumerInfo(Csconsumer csconsumer) {
		this.getHibernateTemplate().save(csconsumer);
		return true;
	}

	public Boolean updateCsconsumerInfo(Csconsumer csconsumer) {
		try {
			this.getHibernateTemplate().update(csconsumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * add by xu 根据id集合返回服务对象
	 * 
	 * @param ids
	 * @return
	 */
	public List<Csconsumer> getByIds(List<Long> ids) {

		// getHibernateTemplate().find("from Csconsumer c from c where c.csId in"
		// );

		Session session = getSession();
		Query query = session.createQuery("from Csconsumer c  where c.csId in (:csIds)");
		query.setParameterList("csIds", ids);

		return query.list();
	}
    
	
	public List<Csconsumer> getCsInfo(String csnameandspell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum) {
		
				String sql = "from Csconsumer where 1=1";
				if (csnameandspell != null && csnameandspell != "") {
					sql = sql + " and (csname like '%" + csnameandspell + "%' or nameForShort like '%" + csnameandspell + "%') ";
				}
				if (idcardNum != null && idcardNum != "") {
					sql = sql + " and idcardNum='" + idcardNum + "' ";
				}
				if (prefecture != null && prefecture != "") {
					sql = sql + " and prefecture='" + prefecture + "' ";
				}
				if (town != null && town != "") {
					sql = sql + " and town='" + town + "' ";
				}
				if (village != null && village != "") {
					sql = sql + " and village='" + village + "' ";
				}
				if (tgroup != null && tgroup != "") {
					sql = sql + " and tgroup='" + tgroup + "' ";
				}
				if (medicalCardNum != null && medicalCardNum != "")// 医疗卡号为空，可能是服务对象没有医疗卡，这种情况不能联合查询，只能查服务对象表
				{ 
					sql = sql + " and csId in(select csId from CsmedicalCard where medicalCardNum='"+ medicalCardNum+"' )";
				}
				//2012-2-13 刘孟丽添加 原因：如有身份证号信息，就无需联合查询
				if (idcardNum != null && idcardNum != "") {
					sql = "from Csconsumer where idcardNum='" + idcardNum + "'";
				}
				List<Csconsumer> list = null;
				try {
					Query query = this.getSession().createQuery(sql);				
					list = query.list();
//					Iterator it = list.iterator();
//					while(it.hasNext()){
//						Csconsumer csc = (Csconsumer)it.next();
//						System.out.println(csc.getCsId() + "\t" + csc.getCsname());
//					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return list;
				
	}
	
	public String[][] getCInfo(String csname,String spell, String idcardNum, String prefecture, String town, String village, String tgroup,
			String medicalCardNum) {
		if (medicalCardNum == null || medicalCardNum == "")// 医疗卡号为空，可能是服务对象没有医疗卡，这种情况不能联合查询，只能查服务对象表
		{
			try {
				String sql = "select c.csId,c.CSName,c.Sex,c.Birthday,c.City,c.Prefecture,c.Town,c.Village,c.IDCardNum,c.Address,c.MateID from CSConsumer c where 1=1 ";
//				String sql = "select * from CSConsumer where 1=1";
				if (csname != null && csname != "") {
//					sql = sql + "and c.csname='" + csname + "' ";
					sql = sql + " and (c.csname like '%" + csname + "%' or c.nameForShort like '%" + csname + "%') ";
				}
				if (spell != null && spell != "") {
//					sql = sql + "and c.nameForShort like '%" + spell +" %' ";
					sql = sql + " and c.nameForShort='" + spell + "' ";
				}
				if (idcardNum != null && idcardNum != "") {
					sql = sql + " and c.idcardNum='" + idcardNum + "' ";
				}
				if (prefecture != null && prefecture != "") {
					sql = sql + " and c.prefecture='" + prefecture + "' ";
				}
				if (town != null && town != "") {
					sql = sql + " and c.town='" + town + "' ";
				}
				if (village != null && village != "") {
					sql = sql + " and c.village='" + village + "' ";
				}
				if (tgroup != null && tgroup != "") {
					sql = sql + " and c.tgroup='" + tgroup + "' ";
				}
				//2012-2-13 刘孟丽添加 原因：如有身份证号信息，就无需联合查询
				if (idcardNum != null && idcardNum != "") {
					sql = "select c.csId,c.CSName,c.Sex,c.Birthday,c.City,c.Prefecture,c.Town,c.Village,c.IDCardNum,c.Address,c.MateID from CSConsumer c where c.idcardNum='" + idcardNum + "'";
				}
				Query query = this.getSession().createSQLQuery(sql);
				List<Object[]> list = query.list();
				int i = list.size();
				String[][] str = new String[i][11];//2012-03-16 刘孟丽修改。数组有原来的[i][10]改为[i][11],因为增加了一个MateID字段
				for (int y = 0; y < i; y++) {
					str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0].toString();
					str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1].toString();
					str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2].toString();
					str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3].toString();
					str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4].toString();
					str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5].toString();
					str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6].toString();
					str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7].toString();
					str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8].toString();
					str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9].toString();
					str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10].toString();
				}
				return str;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		} else {
			String sql = "select c.csId,c.CSName,c.Sex,c.Birthday,c.City,c.Prefecture,c.Town,c.Village,c.IDCardNum ,c.Address,c.MateID from CSConsumer c,CSMedicalCard csm where c.CsID=csm.CsID ";
			sql = sql + "and csm.MedicalCardNum='" + medicalCardNum + "' ";
			if (csname != null && csname != "") {
				sql = sql + "and c.csname='" + csname + "' ";
			}
			if (spell != null && spell != "") {
				sql = sql + "and c.nameForShort='" + spell + "' ";
			}
			if (idcardNum != null && idcardNum != "") {
				sql = sql + "and c.idcardNum='" + idcardNum + "' ";
			}
			if (prefecture != null && prefecture != "") {
				sql = sql + "and c.prefecture='" + prefecture + "' ";
			}
			if (town != null && town != "") {
				sql = sql + "and c.town='" + town + "' ";
			}
			if (village != null && village != "") {
				sql = sql + "and c.village='" + village + "' ";
			}
			if (tgroup != null && tgroup != "") {
				sql = sql + "and c.tgroup='" + tgroup + "' ";
			}
			//2012-2-13 刘孟丽添加 原因：如有身份证号信息，就无需联合查询
			if (idcardNum != null && idcardNum != "") {
				sql = "select c.csId,c.CSName,c.Sex,c.Birthday,c.City,c.Prefecture,c.Town,c.Village,c.IDCardNum,c.Address,c.MateID from CSConsumer c where c.idcardNum='" + idcardNum + "'";
			}
			try {
				Query query = this.getSession().createSQLQuery(sql);
				List<Object[]> list = query.list();
				int i = list.size();
				String[][] str = new String[i][11];//2012-03-16 刘孟丽修改。数组有原来的[i][10]改为[i][11],因为增加了一个MateID字段
				for (int y = 0; y < i; y++) {
					str[y][0] = list.get(y)[0] == null ? "" : list.get(y)[0].toString();
					str[y][1] = list.get(y)[1] == null ? "" : list.get(y)[1].toString();
					str[y][2] = list.get(y)[2] == null ? "" : list.get(y)[2].toString();
					str[y][3] = list.get(y)[3] == null ? "" : list.get(y)[3].toString();
					str[y][4] = list.get(y)[4] == null ? "" : list.get(y)[4].toString();
					str[y][5] = list.get(y)[5] == null ? "" : list.get(y)[5].toString();
					str[y][6] = list.get(y)[6] == null ? "" : list.get(y)[6].toString();
					str[y][7] = list.get(y)[7] == null ? "" : list.get(y)[7].toString();
					str[y][8] = list.get(y)[8] == null ? "" : list.get(y)[8].toString();
					str[y][9] = list.get(y)[9] == null ? "" : list.get(y)[9].toString();
					str[y][10] = list.get(y)[10] == null ? "" : list.get(y)[10].toString();
				}
				return str;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public Csconsumer getCInfoByIDCardNum(String idCardNum) {
		// TODO Auto-generated method stub
		String hql = "from Csconsumer where idCardNum=?";
		
		Query query = super.getSession().createQuery(hql);
		query.setString(0, idCardNum);
		if (query.list().size()>0){
		return (Csconsumer) query.list().get(0);
		}else
		{return null;}
	}

	/**
	 * 计算用户年龄
	 * 
	 * @param useryear,sdata
	 * @return number
	 */
	public int getCountAge(String useryear, String sdate) {
		// 判断参数不为空
		if ((useryear != null || useryear != "") && (sdate != null || sdate != "")) {
			int age = Integer.parseInt(useryear);
			int system = Integer.parseInt(sdate);
			int number = system - age;
			// 结果不能小于0
			if (number > 0) {
				return number;
			} else {
				Log.info("年龄异常");
				return 0;
			}
		} else {
			Log.info("参数异常");
			return 0;
		}
	}

	public List<Csconsumer> getByLikeValue(String value, boolean isSpell) {

		StringBuilder sb = new StringBuilder();
		sb.append("from Csconsumer c where 1=1");

		sb.append(isSpell ? " and nameForShort like ?" : " and csname like ?");

		return getHibernateTemplate().find(sb.toString(), value + "%");

	}

	public List<Csconsumer> getByBirthTime(String startTime, String endTime) {
		Timestamp time1 = Timestamp.valueOf(startTime);// 起始时间
		Calendar t1 = Calendar.getInstance();
		t1.setTime(time1);

		Timestamp time2 = Timestamp.valueOf(endTime);// 终止时间
		Calendar t2 = Calendar.getInstance();
		t2.setTime(time2);
		Query query = this.getSession().createQuery("from Csconsumer c where c.birthday>=? and c.birthday<=?");
		query.setParameter(0, t1.getTime());
		query.setParameter(1, t2.getTime());
		List<Csconsumer> list = query.list();
		return list;

	}

	public List<Csconsumer> getByAge(String nowTime, String csage) {

		return null;
	}

	public List<Csconsumer> getByCondition(List<Long> ids, String consumerName, String idCard, String medicalCard, int flag) {

		StringBuilder sb = new StringBuilder();
		sb.append("select c from Csconsumer c");
		if (null != medicalCard && !"".equals(medicalCard.trim())) {
			sb.append(" ,CsmedicalCard c1 where c1.csId=c.csId ");
		} else
			sb.append(" where 1=1 ");

		List<Object> paramsList = new ArrayList<Object>();
		if (null != consumerName && !"".equals(consumerName.trim())) {
			sb.append(flag == 0 ? " and c.nameForShort like ? " : " and c.csname like ?");
			paramsList.add(consumerName.trim() + "%");
		}
		if (null != idCard && !"".equals(idCard.trim())) {
			sb.append(" and c.idcardNum=?");
			paramsList.add(idCard.trim());
		}
		if (null != medicalCard && !"".equals(medicalCard.trim())) {
			sb.append(" and c1.medicalCardNum=?");
			paramsList.add(medicalCard.trim());
		}

		if (null != ids && ids.size() > 0) {
			sb.append(" and c.csId in (:csIds)");
		}

		Session session = getSession();
		Query query = session.createQuery(sb.toString());

		for (int i = 0; i < paramsList.size(); i++) {
			query.setParameter(i, paramsList.get(i));
		}

		if (null != ids && ids.size() > 0) {
			query.setParameterList("csIds", ids);
		}
		return query.list();
	}

	public List<Csconsumer> getDuiXiangByHuShi(String Shi, String Xian, String Xiang, String Cun, String Zu, String ShengFenZheng, String XingMing , String XingMingSuoXie, Long FuWuDuiXiangID){
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (Shi != null && !Shi.equals("")){
			tj = tj + " city = ?"; //市
			cs.add(Shi);
		}
		if (Xian != null && !Xian.equals("")){ //县
			if (tj.equals("")) 
				tj = " prefecture = ?";
			else
				tj = tj + " and prefecture = ?"; 
			cs.add(Xian);
		}
		if (Xiang != null && !Xiang.equals("")){ //乡
			if (tj.equals("")) 
				tj = " town = ?";
			else
				tj = tj + " and town = ?"; 
			cs.add(Xiang);
		}
		if (Cun != null && !Cun.equals("")){ //村
			if (tj.equals("")) 
				tj = " village = ?";
			else
				tj = tj + " and village = ?"; 
			cs.add(Cun);
		}
		if (Zu != null && !Zu.equals("")){ //组
			if (tj.equals("")) 
				tj = " tgroup = ?";
			else
				tj = tj + " and tgroup = ?"; 
			cs.add(Zu);
		}
		if (ShengFenZheng != null && !ShengFenZheng.equals("")){ //身份证
			if (tj.equals("")) 
				tj = " idcardNum = ?";
			else
				tj = tj + " and idcardNum = ?"; 
			cs.add(ShengFenZheng);
		}
		if (XingMing != null && !XingMing.equals("")){ //姓名
			if (tj.equals("")) 
				tj = " csname like ?";
			else
				tj = tj + " and csname like ?"; 
			cs.add("%"+XingMing+"%");
		}
		if (XingMingSuoXie != null && !XingMingSuoXie.equals("")){ //姓名缩写
			if (tj.equals("")) 
				tj = " nameForShort like ?";
			else
				tj = tj + " and nameForShort like ?"; 
			cs.add("%"+XingMingSuoXie+"%");
		}
		if (FuWuDuiXiangID != -2){
			if (tj.equals("")) 
				tj = " CsID = ?";
			else
				tj = tj + " and CsID = ?"; 
			cs.add(FuWuDuiXiangID);
		}
		
		List<Csconsumer> list = null;
		
		if (tj != null && !tj.equals("")){
			list = this.getHibernateTemplate().find("from Csconsumer where" + tj,cs.toArray());
		}
		else{	
			list = this.getHibernateTemplate().find("from Csconsumer");
		}
		return list;
	}
	
	public List<Csconsumer> getCsconsumerlistByInfo(String csname,String spell,String IDcardnum){
		String	hql="from Csconsumer where ";
		if (csname != null && csname != "") {
			hql = hql + " csname=?";
			
		}
		if (spell!= null && spell != "") {
			hql = hql + " nameForShort like?";
			
		}
		
		if (((csname != null && csname != "")||(spell!= null && spell != ""))&&(IDcardnum != null && IDcardnum != "")) {
			hql = hql + "and idcardNum=?";
			
		}
		if((csname == null || csname == "")&&(spell== null || spell== "")&&(IDcardnum != null && IDcardnum != "")){
			hql = hql + " idcardNum=?";
		}
		
		Query query=this.getSession().createQuery(hql);
		if (csname != null && csname != "") {
			query.setParameter(0, csname);
			
		}
		if (spell != null && spell != "") {
			query.setParameter(0, "%"+spell+"%");
			
		}
		
		if (((csname != null && csname != "")||(spell!= null && spell != ""))&&(IDcardnum != null && IDcardnum != "")) 
		{
			query.setParameter(1, IDcardnum);
			
		}
		if((csname == null || csname == "")&&(spell== null || spell == "")&&(IDcardnum != null && IDcardnum != "")){
			query.setParameter(0, IDcardnum);
		}
		
		
		if (query.list().size()>0){
			return query.list();
			
		}else{
			return null;
		}
		
	}

	public boolean updateCSConsumerZhuYuan(Long CsID, String IDCardNum, String RuralCooperCode, String Cellphone){
		Query query = null;
		query = this.getSession().createSQLQuery("update CSConsumer set IDCardNum = ?, RuralCooperCode = ?, Cellphone = ? where CsID = ?");
		query.setParameter(0,IDCardNum);
		query.setParameter(1,RuralCooperCode);
		query.setParameter(2,Cellphone);
		query.setParameter(3,CsID);
		query.executeUpdate();
		return true;
	}

	public String[][] getFuWuDuiXiangBiao(String Shi, String Xian, String Xiang, String Cun, String XingMing, String XingMingSuoXie){
		Query query = null;
		
		if (XingMing != null && !XingMing.equals("")){
			query = this
			.getSession()
			.createSQLQuery("select " +
					        "  CSName, " + //0姓名
					        "  Sex, " + //1性别
					        "  Birthday, " + //2出生日期
					        "  Address, " + //3住址
					        "  IDCardNum, " + //4身份证号
					        "  Cellphone, " + //5手机
					        "  Telephone, " + //6电话
					        "  CsID " + //7服务对象ID
					        "from CSConsumer " +
					        "where " +
					        "  City = ? and " +
					        "  Prefecture = ? and " +
					        "  Town = ? and " +
					        "  Village = ? and " +
					        "  CSName like ? ");
			query.setParameter(0,Shi);
			query.setParameter(1,Xian);
			query.setParameter(2,Xiang);
			query.setParameter(3,Cun);
			query.setParameter(4,"%"+XingMing+"%");
		}
		else{
			query = this
			.getSession()
			.createSQLQuery("select " +
					        "  CSName, " + //0姓名
					        "  Sex, " + //1性别
					        "  Birthday, " + //2出生日期
					        "  Address, " + //3住址
					        "  IDCardNum, " + //4身份证号
					        "  Cellphone, " + //5手机
					        "  Telephone, " + //6电话
					        "  CsID " + //7服务对象ID
					        "from CSConsumer " +
					        "where " +
					        "  City = ? and " +
					        "  Prefecture = ? and " +
					        "  Town = ? and " +
					        "  Village = ? and " +
					        "  NameForShort = ? ");
			query.setParameter(0,Shi);
			query.setParameter(1,Xian);
			query.setParameter(2,Xiang);
			query.setParameter(3,Cun);
			query.setParameter(4,XingMingSuoXie);
		}
		query.list();
		return listObject2StringString(query.list());
	}
	
}
