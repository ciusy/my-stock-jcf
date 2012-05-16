package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsfnAuthorityForm;

public interface OsfnAuthorityFormDao extends Dao<OsfnAuthorityForm>{
	/**
	 * ��ȡ��Ա��Ӧ�Ĳ˵�
	 * @param sid
	 * @return
	 */
	public List<OsfnAuthorityForm> getOsfnAuthorityFormBySid(long sid);
	/**
	 * ������˵�ID��
	 * @return
	 */
	public Integer getCaiDanMaxID();
	/**
	 * ����˵�
	 * @param osfnAuthorityForm �˵�����
	 * @return
	 */
	public boolean addOSFnAuthorityForm(OsfnAuthorityForm osfnAuthorityForm);
	/**
	 * ����ԱIDɾ����Ӧ�Ĳ˵�
	 * @param SID ��ԱID
	 * @return
	 */
	public boolean delOSFnAuthorityForm(Long SID);
	/**
	 * ��ȡ��¼��Ա�������˵���
	 * @param sid ��ԱID
	 * @return
	 */
	public String[][] getCaiDanShu(long sid);
	/**
	 * ���ݲ˵�ID�޸Ĳ˵�����
	 * @param MenuID �˵�ID
	 * @param MenuName �˵�����
	 * @return
	 */
	public boolean updateCaiDanMingCheng(Integer MenuID, String MenuName);
	/**
	 * ɾ���˵�
	 * @param LeiXing ����(����,ģ��,����)
	 * @param MenuID �˵�ID
	 * @param YuanGongID Ա��ID
	 * @return
	 */
	public boolean delCaiDan(String LeiXing, Integer MenuID, Long YuanGongID);
	/**
	 * ���ÿ�ݰ�ť
	 * @param MenuID �˵�ID
	 * @param QuickName ����
	 * @param QuickImageID ͼ��ID
	 * @param QuickClass ������
	 * @return
	 */
	public boolean updateKuaiJieAnNiu(Integer MenuID, String QuickName, String QuickImageID, String QuickClass);
	/**
	 * ��ȡ��ӦԱ���Ŀ�ݰ�ť
	 * @param SID
	 * @return
	 */
	public String[][] getKuaiJieAnNiu(Long SID);
	/**
	 * ��ȡ��Ӧ�˵��Ŀ�ݰ�ť
	 * @param MenuID
	 * @return
	 */
	public String[][] getKuaiJieAnNiuByCaiDanID(Integer MenuID);
	/**
	 * ��ȡĿ¼
	 * @param sid ��ԱID 
	 * @param FatherMenuID ���˵�ID
	 * @return
	 */
	public String[][] getMuLu(Long sid, Integer FatherMenuID);
	/**
	 * ����Ŀ¼
	 * @param MenuID �˵�ID
	 * @param FatherMenuID ���˵�ID
	 * @return
	 */
	public boolean updateMuLu(Integer MenuID, Integer FatherMenuID);
	/**
	 * �ж�һ�������Ƿ���Ŀ¼��
	 * @param Sid ��ԱID
	 * @param FatherMenuID ���˵�ID
	 * @return
	 */
	public String[][] getZaiMuLuLi(Long Sid, Integer FatherMenuID);
}
