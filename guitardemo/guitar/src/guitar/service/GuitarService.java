package guitar.service;

import java.util.List;

import guitar.entity.Guitar;
import guitar.entity.GuitarSpec;
import net.sf.json.JSONObject;

public interface GuitarService {

	public boolean add(Guitar guitar);
	
	public List<Guitar> getAll();
	
	public Guitar getBySerialNumber(String serialNumber);
	
	public JSONObject searchGuitar(GuitarSpec whatErinLikes);
	
	public boolean delete(String serialNumber);
}