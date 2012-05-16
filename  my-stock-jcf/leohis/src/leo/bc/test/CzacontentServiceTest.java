package leo.bc.test;

import leo.bc.sercive.iface.CzacontentService;
import leo.entity.Czacontent;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

public class CzacontentServiceTest {
	public static void main(String args[]) {

		String url = "http://localhost:8080/leohis/services/CzacontentService";
		Service serviceModel = new ObjectServiceFactory()
				.create(CzacontentService.class);

		try {

			CzacontentService czacontentService = (CzacontentService) new XFireProxyFactory()
					.create(serviceModel, url);
			Czacontent czacontent = czacontentService
					.getCzacontentByItemId("DIS2011021910000");
			System.out.print(czacontent.getItemId() + "   "
					+ czacontent.getIscheck() + "    "
					+ czacontent.getMedicalRecords() + "  "
					+ czacontent.getIsobjectiveRequest() + "  "
					+ czacontent.getClinicalPhenomenon() + "  "
					+ czacontent.getElseState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
