package leo.zy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import leo.common.dao.DaoSupport;
import leo.entity.YfmexbankA;
import leo.entity.ZynurseGrade;
import leo.zy.dao.iface.ZynurseGradeDao;

public class ZynurseGradeDaoImpl extends DaoSupport<ZynurseGrade> implements ZynurseGradeDao {

	public List<ZynurseGrade> getZynurseGrade(Integer JiBieID,
			String JiBieMingCheng) {
		String tj;
		List<Object> cs = new ArrayList<Object>();
		tj = "";
		if (JiBieID != -2){ // 护理级别ID
			tj = " nurseGradeId = ?";
			cs.add(JiBieID);
		}
		if (JiBieMingCheng != null && !JiBieMingCheng.equals("")){ //护理级别名称
			if (tj.equals("")) 
				tj = " nurseGradeName like ?";
			else
				tj = tj + " and nurseGradeName like ?"; 
			cs.add("%"+JiBieMingCheng+"%");
		}
		List<ZynurseGrade> list = null;
		
		if (tj != null && !tj.equals("")){
			list = this.getHibernateTemplate().find("from ZynurseGrade where" + tj,cs.toArray());
		}
		else{	
			list = this.getHibernateTemplate().find("from ZynurseGrade");
		}
		return list;
	}


}
