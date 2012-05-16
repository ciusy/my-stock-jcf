package leo.cf.service.iface;

import java.util.List;

import leo.entity.Cfdhpmodel;
import leo.entity.CfhandleItemDetail;
import leo.entity.Cfmdetail;
import leo.entity.CzdisposeItemDescribe;

/**
 * ������á�����ģ��Service
 * @author Administrator
 *
 */
public interface CfdhpmodelService {
	/**
	 * �����ϡ����á�����ģ��
	 * ����������
	 * �˷����������ģ�壬Ȼ���ѯ�����ģ���ID��
	 * �ò鴦��ģ��ID�ֱ����ҩƷϸ�ںʹ���ϸ�ڡ�
	 * @param cfd ģ��
	 * @param mid ҩƷID
	 * @param unit ��λ
	 * @param quantity ҩƷ����
	 * @param handleItemID ������ĿID
	 * @return
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfd,List<Cfmdetail> cfmList, List<CfhandleItemDetail> cfhList);
	
	/**
	 * ��ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
	 * @return
	 */
	public List<Long> getFactherModelIdEqFactherID();
	/**
	 * ���ز�ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
	 * @return
	 */
	public boolean getFactherModelIdEqFactherID(Integer factherId);
	/**
	 * ����ģ������
	 * ���ݸ��ڵ�ID��ѯ����ģ��
	 * @param factherId
	 * @return
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId);
	/**
	 * ˽��ģ������
	 * ���ظ��ݸ��ڵ�ID��ѯ����ģ��
	 * @param factherId
	 * @return
	 */
	public List<Cfdhpmodel> getCfdhpmodelByFactherId(Long factherId,Long ower);
	/**
	 * ����ģ��IDɾ��ģ��
	 * @param modelId
	 * @return
	 */
	public boolean delCfdhpmodelByModelId(Long modelId);
	/**
	 * ��ģ��Id��Ϊ���ڵ�Id��ѯģ���¼��
	 * @param modelId
	 * @return
	 */
	public boolean getCountByModelId(Long modelId);
	
	/**
	 * ����ģ��ID��ѯҩƷϸ��
	 * @param modelId
	 * @return
	 */
	public List<Cfmdetail> getCfmdetailByModelId(Long modelId);
	/**
	 * ����ģ��Id��ѯ����ϸ��
	 * @return
	 */
	public List<CfhandleItemDetail> getCfhandleItemDetailByModelId(Long modelId);
	/**
	 * ����ģ��ID��ѯģ��
	 * @return
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId);
	/**
	 * ������Ŀ����Id��ѯ������Ŀ
	 * @param modelId
	 * @return
	 */
	public CzdisposeItemDescribe getCzdisposeItemDescribeByitemTypeId(Integer itemId);
	/**
	 * ��Ӵ���ϸ��
	 * @param cfh
	 * @return
	 */
	public boolean addCfhandleItemDetail(CfhandleItemDetail cfh);
	/**
	 * ���ҩƷϸ��
	 * @param cfm
	 * @return
	 */
	public boolean addCfmdetail(Cfmdetail cfm);
	/**
	 * ɾ������ϸ��
	 * @param itemId ҩƷϸ��Id
	 * @return
	 */
	public boolean delCfhandleItemDetail(Long itemId);
	/**
	 * ɾ��ҩƷϸ��
	 * @param iid
	 * @return
	 */
	public boolean delCfmdetail(Long iid);
	/**
	 * ��ȡҩƷϸ�����Id
	 * @return
	 */
	public Long getMaxIid();
	/**
	 * ��ȡ�����ϸ��Id
	 * @return
	 */
	public Long getMaxItemId();
	/**
	 * ����ģ������
	 * @return
	 */
	public boolean addCfdhpmodelType(Cfdhpmodel cfd);
	/**
	 * ��ѯģ������
	 * @param ower
	 * @return
	 */
	public List<Cfdhpmodel> getCfdhpmodelType(String ower);
	/**
	 * ɾ��ģ������
	 * @param modelId
	 * @return
	 */
	public boolean delCfdhpmodelType(Long factherId);
	/**
	 * ��ѯģ���Ƿ����
	 * @param modelName
	 * @return
	 */
	public boolean getCfdhpmodelByName(String modelName);
	/**
	 * ��ѯģ�������Ƿ����
	 * @param modelName
	 * @return
	 */
	public boolean getCfdhpmodelTypeByName(String modelName, String ower);
}
