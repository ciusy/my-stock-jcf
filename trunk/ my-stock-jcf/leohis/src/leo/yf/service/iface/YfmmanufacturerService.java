package leo.yf.service.iface;

import java.util.List;

import leo.entity.Yfmmanufacturer;

public interface YfmmanufacturerService {
	public List<Yfmmanufacturer> getYfmmanufacturer(String name);
	public Boolean addYfmmanufacturer(Yfmmanufacturer yfmmanufacturer);	
    public Boolean delYfmmanufacturer(String manufacturer);
	
}

