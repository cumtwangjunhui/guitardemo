package impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import guitar.action.Inventory;
import guitar.entity.Guitar;
import guitar.entity.GuitarSpec;
import guitar.mapper.GuitarMapper;
import guitar.service.GuitarService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("guitarService")
public class GuitarServiceImpl implements GuitarService {
	@Autowired
	private GuitarMapper guitarMapper;
	
//	private GuitarDao guitarDao = DataAccess.createGuitarDao();



	@Override

	public boolean add(Guitar guitar) {

		return guitarMapper.add(guitar.getSerialNumber(), guitar.getPrice(), guitar.getSpec().getSerialNumber());

	}



	@Override

	public List<Guitar> getAll() {

		return guitarMapper.getAll();

	}



	@Override

	public Guitar getBySerialNumber(String serialNumber) {

		return guitarMapper.getBySerialNumber(serialNumber);

	}



	@Override

	public JSONObject searchGuitar(GuitarSpec whatErinLikes) {

		

		JSONObject jsonObject = new JSONObject();

		

		Inventory inventory = new Inventory();


		inventory.setGuitars(this.getAll());

		

		List<Guitar> matchingGuitars = new LinkedList<Guitar>();

		


		

		if( whatErinLikes.getModel() != null && !whatErinLikes.getModel().equals("") ){

			matchingGuitars = inventory.search(whatErinLikes);

		}else{

			matchingGuitars = inventory.getGuitars();

		}

		

		JSONArray ja = new JSONArray();

		for( Guitar guitar : matchingGuitars ){

			JSONObject jo = new JSONObject();

			jo.put("serialNumber", guitar.getSerialNumber());

			jo.put("builder", guitar.getSpec().getBuilder().toString());

			jo.put("model", guitar.getSpec().getModel());

			jo.put("type", guitar.getSpec().getType().toString());

			jo.put("numStrings", guitar.getSpec().getNumStrings());

			jo.put("backWood", guitar.getSpec().getBackWood().toString());

			jo.put("topWood", guitar.getSpec().getTopWood().toString());

			jo.put("price", guitar.getPrice());

			ja.add(jo);

		}

		jsonObject.put("data", ja);

		jsonObject.put("recordsTotal", matchingGuitars.size());

		

		return jsonObject;

	}



	@Override

	public boolean delete(String serialNumber) {

		return guitarMapper.delete(serialNumber);

	}
	


}