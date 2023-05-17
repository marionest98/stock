package stock_m.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SellDto {
	private int sno; 
	private String userid; 
	private int pno;
	private Date sdate;  
	private int price; 
	private int scount;
}
