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
	public List<Cfprefecture> getPrefectureIdByCityID(long  cityId);//根据市的ID返回所有县
	public Cfprefecture getPrefectureByPrefectureID(long   prefectureId) ;//根据县的id得到县
	public List<Cftown> getAllTownByPrefectureId(long prefectureId);
	public Cftown getTownByTownId(long townId);//根据乡镇id得到乡镇
	public List<Cftown> getAllTownByPrefectureName(String prefectureName);
	public List<Cfvillage> getAllVilleagesByTownId(long townId);//输入所在的乡镇id，返回所有的村
	public List<Cfvillage> getAllVilleagesByTownName(String townName);//输入所在的乡镇名称，返回所有的村
	public List<Cfgroup> getAllCfgroupsByVilleageId(long villeageId);//输入所在的村id，返回所有的组
	public List<Cfgroup> getAllCfgroupsByVilleageName(String villeageName);//输入所在的村名称，返回所有的组
	public Cfvillage getVillageByVillageId(long  villageId);
	public Cfgroup getCfgroupByCfgroupId(long groupId);
	public Cfcity getcityBycityID(long cityId);
	public List<Cfprefecture> getPrefectureByCityID(long cityId);
	public String[][] getinfobydisposename(String dname);
	public boolean addcfstuff(Cfstuff cfstuff);
	public boolean deletecfstuff(int id);
	public boolean updatecfstuff(int id,String value,int sid);
}
