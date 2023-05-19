package stock_m.dto;

<<<<<<< HEAD
import java.util.Date;

import lombok.Data;
@Data
public class StockDto {
	private int sno;  
	private int s_val; 
	private String userid; 
	private String scontent; 
	private int s_volume; 
	private Date s_date;
=======
import lombok.Data;

@Data
public class StockDto {
	private String userid;
	private String scontent;
	private int s_val;
	private int s_volume;
	private String s_date;
>>>>>>> main
}
