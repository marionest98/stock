package stock_m.dto;

import java.util.Date;

<<<<<<< HEAD
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BuyDto {
	private int bno; 
	private int pno; 
	private String userid; 	
	private Date bdate; 
	private int price;
	private int bcount;
=======
public class BuyDto {

	private int sno; 
	private String userid;
	private int product_pno;
	private Date sdate;
	private int price;
	private int bcount;

>>>>>>> main
}
