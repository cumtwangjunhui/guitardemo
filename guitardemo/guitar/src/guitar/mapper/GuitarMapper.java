package guitar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import guitar.entity.Guitar;

public interface GuitarMapper {
	
	@Select("select id,serialNumber,price from guitar")
	List<Guitar> getAll();


	@Insert("INSERT INTO GUITAR VALUES (?, ?, ?);")
	boolean add(String serialNumber1,double price,String serialNumber2);

	@Select("SELECT * FROM GUITAR WHERE serialNumber=?")
	Guitar getBySerialNumber(String serialNumber);

	@Delete("DELETE FROM GUITAR WHERE serialNumber=?")
	boolean delete(String serialNumber);
	
}