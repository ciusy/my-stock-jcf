package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfprefecture;

public interface CfprefectureDao {
  public Cfprefecture getPrefectureIdByPrefectureName(String  prefectureName);
  public List<Cfprefecture> getPrefectureIdByCityID(long  cityId);
  public Cfprefecture getPrefectureByPrefectureID(long   prefectureId);
  /**
   * 根据市ID查询县
   * @param cityId
   * @return
   */
  public List<Cfprefecture> getPrefectureByCityID(long cityId);
  /**
   * 根据县id查询县名
   * @param prefectureId
   * @return
   */
  public String getPrefectureByprefectureId(Long prefectureId);
}
