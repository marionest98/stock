package stock_m.dto;

import lombok.Data;

@Data
public class BroadcastPriceDto {
	private int pbrno;
	private String userid;
	private int br_search;
	private int br_param;
}
