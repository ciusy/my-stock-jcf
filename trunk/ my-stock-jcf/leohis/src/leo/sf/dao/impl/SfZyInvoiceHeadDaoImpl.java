package leo.sf.dao.impl;

import leo.common.dao.DaoSupport;
import leo.entity.SfzyinvoiceHead;
import leo.sf.dao.iface.SfZyInvoiceHeadDao;

public class SfZyInvoiceHeadDaoImpl extends DaoSupport<SfzyinvoiceHead>
		implements SfZyInvoiceHeadDao {

	public SfzyinvoiceHead getByMedOrgId(Integer medOrgId, Long invoiceNO) {
		return getSingleData("o.medOrgId=? and o.invoiceNo=?", new Object[] {
				medOrgId, invoiceNO });
	}

}
