package leo.yf.service.iface;

import java.util.List;

import leo.entity.YfapproveTable;

public interface YFApproveTableService {
	public Long getMaxID();
	/**
	 * ��ѯ����������
	 * @return
	 */
	public List<YfapproveTable> getYfapproveTableAll();
	/**
	 * ���ݼ�¼ID��ѯ������
	 * @param recordId
	 * @return
	 */
	public List<YfapproveTable> getYfapproveTableByRecordId(String recordId);
	/**
	 * �޸�����״̬
	 * @param aformId ������ID
	 * @param status ״̬
	 * @param approve ������ID
	 * @param note �ܾ�ԭ��
	 * @return
	 */
	public String updateStatus(Long approveFormId,String status,Long approve,String note);
}
