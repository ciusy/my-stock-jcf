package leo.cf.service.iface;

import java.util.List;

import leo.entity.Cfcity;
import leo.entity.Cfgroup;
import leo.entity.Cfprefecture;
import leo.entity.Cfstuff;
import leo.entity.Cftown;
import leo.entity.Cfvillage;

public interface CfGiveGhService {
	public Cfprefecture getPrefectureIdByPrefectureName(String  prefectureName);
	public String getPersonalConfiguration(String dname,long sid);
	public List<Cfprefecture> getPrefectureIdByCityID(long  cityId);//�����е�ID����������
	public Cfprefecture getPrefectureByPrefectureID(long   prefectureId) ;//�����ص�id�õ���
	public List<Cftown> getAllTownByPrefectureId(long prefectureId);
	public Cftown getTownByTownId(long townId);//��������id�õ�����
	public List<Cftown> getAllTownByPrefectureName(String prefectureName);
	public List<Cfvillage> getAllVilleagesByTownId(long townId);//�������ڵ�����id���������еĴ�
	public List<Cfvillage> getAllVilleagesByTownName(String townName);//�������ڵ��������ƣ��������еĴ�
	public List<Cfgroup> getAllCfgroupsByVilleageId(long villeageId);//�������ڵĴ�id���������е���
	public List<Cfgroup> getAllCfgroupsByVilleageName(String villeageName);//�������ڵĴ����ƣ��������е���
	public Cfvillage getVillageByVillageId(long  villageId);
	public Cfgroup getCfgroupByCfgroupId(long groupId);
	public Cfcity getcityBycityID(long cityId);
	public List<Cfprefecture> getPrefectureByCityID(long cityId);
	public String[][] getinfobydisposename(String dname);
	public boolean addcfstuff(Cfstuff cfstuff);
	public boolean deletecfstuff(int id);
	public boolean updatecfstuff(int id,String value,int sid);
}
