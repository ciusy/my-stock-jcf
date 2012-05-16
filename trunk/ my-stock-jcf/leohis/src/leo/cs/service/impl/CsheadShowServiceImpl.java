package leo.cs.service.impl;

import leo.cs.dao.iface.CsheadShowDao;
import leo.cs.service.iface.CsheadShowService;
import leo.entity.CsheadShow;
import leo.util.FileUtil;

public class CsheadShowServiceImpl implements CsheadShowService {
	private CsheadShowDao csheadShowDao;
	public void setCsheadShowDao(CsheadShowDao csheadShowDao) {
		this.csheadShowDao = csheadShowDao;
	}

	
	public boolean addCsheadShow(long id,byte[] bytes,String name) {
		if(bytes.length != 0){
			boolean result = FileUtil.addFile(name, bytes);
			//添加头像到头像表
			String url = "";
			if(result){
				url = ""+name+".jpg";
				CsheadShow cs = new CsheadShow();
				cs.setCsId(id);
				cs.setHeadShow(url);
				boolean flag = csheadShowDao.addCsheadShow(cs);
	System.out.println(flag);
			}
			return result;
		}
		return false;
	}

	public boolean delCsheadShow(CsheadShow csheadShow) {
		return false;
	}

	public String getCsheadShowById(long id) {
		return csheadShowDao.getCsheadShowById(id);
	}

	public boolean updateCsheadShow(long id,byte[] bytes,String name) {
		if(bytes.length != 0){
			boolean result = FileUtil.addFile(name, bytes);
			//添加头像到头像表
			String url = "";
			if(result){
				url = ""+name+".jpg";
				String csurl=csheadShowDao.getCsheadShowById(id);
				if (csurl!=null&&csurl!="")
				{
				CsheadShow cs = new CsheadShow();
				cs.setCsId(id);
				cs.setHeadShow(url);
				boolean flag = csheadShowDao.updateCsheadShow(cs);
				}else{
					CsheadShow cs = new CsheadShow();
					cs.setCsId(id);
					cs.setHeadShow(url);
					boolean flag = csheadShowDao.addCsheadShow(cs);	
				}
			}
			return result;
		}
		return false;
	}

}
