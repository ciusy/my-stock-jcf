package leo.sf.dao.iface;

import java.util.List;
import java.util.Set;

import leo.common.dao.Dao;
import leo.entity.SfmzinvoiceHead;

public interface SfMzInvoiceHeadDao extends Dao<SfmzinvoiceHead> {

	public SfmzinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO);

	public void updateStatus(Set<Long> invoiceNOs, boolean b);

	public List<List<String>> getPrescriptions(Set<Long> invoiceNOs, boolean b);

	public List<List<String>> getDisposes(Set<Long> invoiceNOs, boolean b);

	public SfmzinvoiceHead getById(Long firstInvoiceNo);

	public List<List<String>> getPrescriptionsExcept(Set<Long> invoiceNOs,
			boolean b, Set<String> storageItemIds);

}
