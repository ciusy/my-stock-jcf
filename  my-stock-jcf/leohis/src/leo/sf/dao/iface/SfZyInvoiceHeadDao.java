package leo.sf.dao.iface;

import leo.common.dao.Dao;
import leo.entity.SfzyinvoiceHead;

public interface SfZyInvoiceHeadDao extends Dao<SfzyinvoiceHead> {

	SfzyinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO);

}
