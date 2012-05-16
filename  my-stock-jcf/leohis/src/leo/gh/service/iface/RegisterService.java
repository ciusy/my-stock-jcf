package leo.gh.service.iface;

import java.util.Date;
import java.util.List;

import leo.entity.GhcostType;
import leo.entity.Ghregister;
import leo.entity.GhregisterDivaricateU;
import leo.entity.GhregisterType;
import leo.entity.Osuform;

public interface RegisterService {
	/**
	 * 根据医疗单位查找所有费用类型
	 * @return 返回找到的费用类型
	 */
	public List<GhcostType> getAllGhcostTypeByMid(int mid);
	/**
	 * 查找所有的挂号类型
	 * @return 返回找到的挂号类型
	 */
	public List<GhregisterType> getAllGhregisterType(int uid);
	/**
	 * 通过费用类型查找科室，需要注入osService
	 * @param id 费用类型id
	 * @return 此费用类型下的科室
	 */
	public List<Osuform> getUFormByRegestTypeId (int id);
	/**
	 * 保存费用类型
	 * @param ghcostType 费用类型对象
	 * @return 返回是否保存成功
	 */
	public boolean addGhcostType(GhcostType ghcostType); 
	/**
	 * 更新费用类型
	 * @param ghcostType 费用类型对象
	 * @return 返回是否更新成功
	 */
	public boolean updateGhcostType(GhcostType ghcostType);
	/**
	 * 删除费用类型
	 * @param ghcostType 费用类型对象
	 * @return 返回是否删除成功
	 */
     public boolean deleteGhcostType(GhcostType ghcostType);
     /**
      * 通过挂号类型Id查找挂号类型
      * @param id 挂号类型ID
      * @return
      */
     public GhregisterType getGhregisterTypeById(int id);
     /**
      * 通过科室ID查找挂号类型列表
      * @param uId 科室ID
      * @return
      */
     public List<GhregisterType> getGhregisterTypeByUid(int uId1,int uId2);
     /**
      * 通过ID获得费用类型
      * @param id 费用类型ID
      * @return
      */
     public GhcostType getGhcostTypeByid(int id);
     /**
      * 通过RTID获得开出科室
      * @param rtid 挂号类型ID
      * @return
      */
     public List<GhregisterDivaricateU> getAllGhregisterDivaricateUByRTID(int rtid);
    
     /**
      * 增加开出科室
      * @param ghregisterDivaricateU
      * @return
      */
     public boolean addGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
     /**
      * 增加挂号类型
      * @param ghregisterType
      * @return
      */
     public boolean addGhregisterType(GhregisterType ghregisterType);
     /**
      * 通过挂号项目名查找挂号类型
      * @param rpname
      * @return
      */
     public GhregisterType getGhregisterTypeByRPname(String rpname);
     /**
      * 通过医疗机构ID挂号类型
      * @param mid
      * @return
      */
     public List<GhregisterType> getAllGhregisterTypeByMid(int mid);
     /**
      * 添加挂号对象
      * @param ghregister 挂号对象
      * @return
      */
     public boolean addGhregister(Ghregister ghregister, boolean card,boolean cord,int medicalInstId);
     /**
      * 查找所有挂号对象
      * @return
      */
	 public List<Ghregister> getAllGhregister();
	 /**
	  * 通过门诊号查找挂号对象
	  * @param opnum 门诊号
	  * @return
	  */
	 public Ghregister getGhregisterByOpnum(String opnum);
	 /**
	  * 更新挂号
	  * @param ghregister 挂号对象
	  * @return
	  */
	 public boolean updateGhregister(Ghregister ghregister,boolean card,int medicalInstId);
	 /**
	  * 删除挂号
	  * @param ghregister 挂号对象
	  * @return
	  */
	 public boolean deleteGhregister(Ghregister ghregister);
	 /**
	  * 删除挂号类型
	  * @param ghregisterType 挂号类型
	  * @return
	  */
		public boolean deleteGhregisterType(GhregisterType ghregisterType);
		 /**
		  * 更新挂号类型
		  * @param ghregisterType 挂号类型
		  * @return
		  */
		public boolean updateGhregisterType(GhregisterType ghregisterType);
		/**
		  * 更新开出科室
		  * @param ghregisterDivaricateU 开出科室
		  * @return
		  */
		public boolean updateGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
		 /**
		  * 删除开出科室
		  * @param ghregisterDivaricateU 开出科室
		  * @return
		  */
		public boolean deleteGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
		 /**
		  * 返回挂号类型ID
		  * @param mid 医疗机构ID rpname 挂号项目名
		  * @return
		  */
		public int getRtidByUName(int mid , String rpname);
		/**
		 * 通过日期，服务对象姓名，身份证号，门诊号，医疗卡号查找挂号
		 * @param strDate
		 * @param endDate
		 * @param csName
		 * @param mcardNum
		 * @param opNum
		 * @param cscardNum
		 * @return
		 */
		public String[][] getGhregisterByCondition(String strDate,
				String endDate, String csName, String mcardNum, String opNum,
				String cscardNum,int uid);
		/**
		 * 根据门诊号删除挂号
		 * @param opnum
		 * @return
		 */
		public boolean deleteGhregisterByOpnum(String opnum);
		/**
		 * 通过日期，挂号状态查挂号
		 * @param strDate
		 * @param endDate
		 * @param rstatus
		 * @return
		 */
		public String[][] getGhregisterByDateandRstatus(String stdate,String eddate,String rstatus,int uid);
		public String[][] getrnameandrtidbyuid(int uid);
		public boolean updateGhregisteronly(Ghregister ghregister);
		public List<GhregisterType> getGhregisterTypebyghuid(int uid);
		public String getMaxopnumByDate(String date);
		public List<Ghregister> getGhregisterfortg(long sid,String stdate,String eddate) throws Exception;
}
