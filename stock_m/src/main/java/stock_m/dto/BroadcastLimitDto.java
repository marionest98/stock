package stock_m.dto;

import lombok.Data;

@Data
public class BroadcastLimitDto {
	private int lbrno;
	private String userid;
	private int limit;
}
