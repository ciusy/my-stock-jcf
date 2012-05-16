package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfprefecture;

public interface CfprefectureDao {
  public Cfprefecture getPrefectureIdByPrefectureName(String  prefectureName);
  public List<Cfprefecture> getPrefectureIdByCityID(long  cityId);
  public Cfprefecture getPrefectureByPrefectureID(long   prefectureId);
  /**
   * ������ID��ѯ��
   * @param cityId
   * @return
   */
  public List<Cfprefecture> getPrefectureByCityID(long cityId);
  /**
   * ������id��ѯ����
   * @param prefectureId
   * @return
   */
  public String getPrefectureByprefectureId(Long prefectureId);
}
