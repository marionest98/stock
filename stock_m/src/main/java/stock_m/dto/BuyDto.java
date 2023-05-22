package stock_m.dto;

import java.util.Date;


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

}
