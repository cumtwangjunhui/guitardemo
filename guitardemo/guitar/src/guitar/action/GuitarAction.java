package guitar.action;

import java.util.LinkedList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import guitar.entity.Builder;
import guitar.entity.Guitar;
import guitar.entity.GuitarSpec;
import guitar.entity.Type;
import guitar.entity.Wood;
import guitar.service.GuitarService;
import guitar.service.impl.GuitarServiceImpl;
import net.sf.json.JSONObject;

public class GuitarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String serialNumber;

	private Builder builder;

	private String model;

	private Type type;

	private double price;

	private int numStrings;

	private Wood backWood;

	private Wood topWood;

	private List<Guitar> matchingGuitars = new LinkedList<Guitar>();

	private JSONObject jsonObject = new JSONObject();

	

	public String search(){

		

		GuitarService guitarService = new GuitarServiceImpl();

		

		GuitarSpec whatErinLikes = 

				new GuitarSpec(builder, model, type, numStrings, backWood, topWood);

		

		jsonObject = guitarService.searchGuitar(whatErinLikes);

		

		return SUCCESS;

	}



	public String addGuitar() {

		

		GuitarSpec spec = new GuitarSpec(builder, model, type,

                numStrings, backWood, topWood);

		

		Guitar guitar = new Guitar(serialNumber, price, spec);

		

		GuitarService guitarService = new GuitarServiceImpl();

		

		boolean flag = guitarService.add(guitar);

		

		if( flag ){

			jsonObject.put("message", SUCCESS);

		}else{

			jsonObject.put("message", ERROR);

		}

		

		return SUCCESS;

	}



	public String deleteGuitar() {

		

		GuitarService guitarService = new GuitarServiceImpl();

		

		boolean flag = guitarService.delete(serialNumber);

		

		if( flag ){

			jsonObject.put("message", SUCCESS);

		}else{

			jsonObject.put("message", ERROR);

		}

		

		return SUCCESS;

	}

	

	

	

	public String getSerialNumber() {

		return serialNumber;

	}

	public void setSerialNumber(String serialNumber) {

		this.serialNumber = serialNumber;

	}

	public double getPrice() {

		return price;

	}

	public void setPrice(double price) {

		this.price = price;

	}

	public Builder getBuilder() {

		return builder;

	}

	public void setBuilder(Builder builder) {

		this.builder = builder;

	}

	public String getModel() {

		return model;

	}

	public void setModel(String model) {

		this.model = model;

	}

	public Type getType() {

		return type;

	}

	public void setType(Type type) {

		this.type = type;

	}

	public int getNumStrings() {

		return numStrings;

	}

	public void setNumStrings(int numStrings) {

		this.numStrings = numStrings;

	}

	public Wood getBackWood() {

		return backWood;

	}

	public void setBackWood(Wood backWood) {

		this.backWood = backWood;

	}

	public Wood getTopWood() {

		return topWood;

	}

	public void setTopWood(Wood topWood) {

		this.topWood = topWood;

	}



	public List<Guitar> getMatchingGuitars() {

		return matchingGuitars;

	}



	public void setMatchingGuitars(List<Guitar> matchingGuitars) {

		this.matchingGuitars = matchingGuitars;

	}



	public JSONObject getJsonObject() {

		return jsonObject;

	}



	public void setJsonObject(JSONObject jsonObject) {

		this.jsonObject = jsonObject;

	}
}