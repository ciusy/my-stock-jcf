package leo.cf.dao.iface;

import java.util.List;

import leo.entity.Cfdhpmodel;

/**
 * ��ϡ����á�����ģ��DAO
 * @author Administrator
 *
 */
public interface CfdhpmodelDao {
	/**
	 * �����ϡ����á�����ģ��
	 * @param cfp
	 * @return
	 */
	public boolean addCfdhpmodel(Cfdhpmodel cfp);
	/**
	 * ��ѯ������ӵ�ģ��ID
	 * @return
	 */
	public long getNewAddModelId();
	/**
	 * �޸ĸ��ڵ�ID
	 * @param cfp
	 * @return
	 */
	public boolean updateFactherID(Cfdhpmodel cfp);
	/**
	 * ����ģ��ID��ѯģ��
	 * @return
	 */
	public Cfdhpmodel getCfdhpmodelByModelId(Long modelId);
	/**
	 * ��ѯ���ڵ�ID��ģ��IDһ���ĸ��ڵ�
	 * @return
	 */
	public List<Long> getFactherModelIdEqFactherID();
	/**
	 * ���ز�ѯ���и��ڵ�ID��ģ��IDһ���ĸ��ڵ�
	 * @return
	 */
	public List<Cfdhpmodel> getFactherModelIdEqFactherID(Integer factherId);
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
	 * ɾ��ģ��
	 * @param modelId
	 * @return
	 */
	public boolean delCfdhpmodelByModelId(Long modelId);
	/**
	 * ��ģ��Id��Ϊ���ڵ�Id��ѯģ���¼��
	 * @param modelId
	 * @return
	 */
	public int getCountByModelId(Long modelId);
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
