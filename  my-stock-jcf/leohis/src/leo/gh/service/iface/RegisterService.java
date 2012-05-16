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
	 * ����ҽ�Ƶ�λ�������з�������
	 * @return �����ҵ��ķ�������
	 */
	public List<GhcostType> getAllGhcostTypeByMid(int mid);
	/**
	 * �������еĹҺ�����
	 * @return �����ҵ��ĹҺ�����
	 */
	public List<GhregisterType> getAllGhregisterType(int uid);
	/**
	 * ͨ���������Ͳ��ҿ��ң���Ҫע��osService
	 * @param id ��������id
	 * @return �˷��������µĿ���
	 */
	public List<Osuform> getUFormByRegestTypeId (int id);
	/**
	 * �����������
	 * @param ghcostType �������Ͷ���
	 * @return �����Ƿ񱣴�ɹ�
	 */
	public boolean addGhcostType(GhcostType ghcostType); 
	/**
	 * ���·�������
	 * @param ghcostType �������Ͷ���
	 * @return �����Ƿ���³ɹ�
	 */
	public boolean updateGhcostType(GhcostType ghcostType);
	/**
	 * ɾ����������
	 * @param ghcostType �������Ͷ���
	 * @return �����Ƿ�ɾ���ɹ�
	 */
     public boolean deleteGhcostType(GhcostType ghcostType);
     /**
      * ͨ���Һ�����Id���ҹҺ�����
      * @param id �Һ�����ID
      * @return
      */
     public GhregisterType getGhregisterTypeById(int id);
     /**
      * ͨ������ID���ҹҺ������б�
      * @param uId ����ID
      * @return
      */
     public List<GhregisterType> getGhregisterTypeByUid(int uId1,int uId2);
     /**
      * ͨ��ID��÷�������
      * @param id ��������ID
      * @return
      */
     public GhcostType getGhcostTypeByid(int id);
     /**
      * ͨ��RTID��ÿ�������
      * @param rtid �Һ�����ID
      * @return
      */
     public List<GhregisterDivaricateU> getAllGhregisterDivaricateUByRTID(int rtid);
    
     /**
      * ���ӿ�������
      * @param ghregisterDivaricateU
      * @return
      */
     public boolean addGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
     /**
      * ���ӹҺ�����
      * @param ghregisterType
      * @return
      */
     public boolean addGhregisterType(GhregisterType ghregisterType);
     /**
      * ͨ���Һ���Ŀ�����ҹҺ�����
      * @param rpname
      * @return
      */
     public GhregisterType getGhregisterTypeByRPname(String rpname);
     /**
      * ͨ��ҽ�ƻ���ID�Һ�����
      * @param mid
      * @return
      */
     public List<GhregisterType> getAllGhregisterTypeByMid(int mid);
     /**
      * ��ӹҺŶ���
      * @param ghregister �ҺŶ���
      * @return
      */
     public boolean addGhregister(Ghregister ghregister, boolean card,boolean cord,int medicalInstId);
     /**
      * �������йҺŶ���
      * @return
      */
	 public List<Ghregister> getAllGhregister();
	 /**
	  * ͨ������Ų��ҹҺŶ���
	  * @param opnum �����
	  * @return
	  */
	 public Ghregister getGhregisterByOpnum(String opnum);
	 /**
	  * ���¹Һ�
	  * @param ghregister �ҺŶ���
	  * @return
	  */
	 public boolean updateGhregister(Ghregister ghregister,boolean card,int medicalInstId);
	 /**
	  * ɾ���Һ�
	  * @param ghregister �ҺŶ���
	  * @return
	  */
	 public boolean deleteGhregister(Ghregister ghregister);
	 /**
	  * ɾ���Һ�����
	  * @param ghregisterType �Һ�����
	  * @return
	  */
		public boolean deleteGhregisterType(GhregisterType ghregisterType);
		 /**
		  * ���¹Һ�����
		  * @param ghregisterType �Һ�����
		  * @return
		  */
		public boolean updateGhregisterType(GhregisterType ghregisterType);
		/**
		  * ���¿�������
		  * @param ghregisterDivaricateU ��������
		  * @return
		  */
		public boolean updateGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
		 /**
		  * ɾ����������
		  * @param ghregisterDivaricateU ��������
		  * @return
		  */
		public boolean deleteGhregisterDivaricateU(GhregisterDivaricateU ghregisterDivaricateU);
		 /**
		  * ���عҺ�����ID
		  * @param mid ҽ�ƻ���ID rpname �Һ���Ŀ��
		  * @return
		  */
		public int getRtidByUName(int mid , String rpname);
		/**
		 * ͨ�����ڣ�����������������֤�ţ�����ţ�ҽ�ƿ��Ų��ҹҺ�
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
		 * ���������ɾ���Һ�
		 * @param opnum
		 * @return
		 */
		public boolean deleteGhregisterByOpnum(String opnum);
		/**
		 * ͨ�����ڣ��Һ�״̬��Һ�
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
