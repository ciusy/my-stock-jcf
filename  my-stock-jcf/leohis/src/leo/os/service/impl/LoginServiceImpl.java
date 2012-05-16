package leo.os.service.impl;

import java.util.List;

import leo.entity.OsfnAuthorityForm;
import leo.entity.Osstuff;
import leo.entity.Osuform;
import leo.os.dao.iface.OsfnAuthorityFormDao;
import leo.os.dao.iface.OsmedicalInstInfoDao;
import leo.os.dao.iface.OsstuffDao;
import leo.os.dao.iface.OsuformDao;
import leo.os.service.iface.LoginService;

public class LoginServiceImpl  implements LoginService {
	/**
	 * set方法，用于Spring注入
	 */
	private OsstuffDao osstuffDao;
	private OsuformDao osuformDao;
	private OsfnAuthorityFormDao osfnAuthorityFormDao;
	private OsmedicalInstInfoDao osmedicalInstInfoDao;
	public void setOsstuffDao(OsstuffDao osstuffDao) {
		this.osstuffDao = osstuffDao;
	}
	public void setOsuformDao(OsuformDao osuformDao) {
		this.osuformDao = osuformDao;
	}
	public void setOsfnAuthorityFormDao(OsfnAuthorityFormDao osfnAuthorityFormDao) {
		this.osfnAuthorityFormDao = osfnAuthorityFormDao;
	}
	public void setOsmedicalInstInfoDao(OsmedicalInstInfoDao osmedicalInstInfoDao) {
		this.osmedicalInstInfoDao = osmedicalInstInfoDao;
	}
	
	public String[] getLoginInfo(String loginName, String password) {
//System.out.println(loginName+","+password);
		String[] strs = new String[6];
		try{
			Osstuff osStuff = osstuffDao.getStuffByNameAndPassword(loginName, password);
			if(osStuff != null){
				strs[0] = osStuff.getSid().toString();
				strs[1] = osStuff.getSname();
				strs[4] = osStuff.getMeiid().toString();
				Osuform osUfrom = osuformDao.getUformByUid(osStuff.getDefaultU());
				if(osUfrom != null){
					strs[2] = osUfrom.getUid().toString();
					strs[3] = osUfrom.getUname();
				}else{
					strs[2] = "";
					strs[3] = "";
				}
				strs[5] = osmedicalInstInfoDao.getOsmedicalInstInfoName(osStuff.getMeiid());
			}else{
				strs[0] = "";
				strs[1] = "";
				strs[4] = "";
			}
			return strs;
		}catch (Exception e){
			e.printStackTrace();
		}
		return strs;
	}

	public List<OsfnAuthorityForm> getFnAuthorityFormBySid(long sid) {
		return osfnAuthorityFormDao.getOsfnAuthorityFormBySid(sid);
	}

	public String changePassword (String loginname ,String oldpassword, String newpassword1, String newpassword2){
		return osstuffDao.changePassword(loginname, oldpassword, newpassword1, newpassword2);
	}

}

