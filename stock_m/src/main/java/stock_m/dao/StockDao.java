/*
   Date    : 2023.05.15
   name    : StockDao
   type    : Dao
   ver     : 1.1
   connect  : StockService
   content : 재고관리 서비스
   writer  : 이이지
   api     : x
  */
package stock_m.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import stock_m.dto.StockDto;

@Mapper
public interface StockDao {
	//재고 
	
	
		@Select("select * from stock where userid = #{'1'}")
		List<StockDto> sList(String userid);
		
		@Update("update stock set price=#{price} where sno=#{sno}")
		int supdate(List<StockDto> dto);	
		
		@Delete ("delete from stock where sno = #{sno}")
		int sdelete(int sno);
		
		@Select("select * from stock where scontent like concat('%',#{scontent},'%')")
		public List<StockDto> searchscontent(String search);

		@Insert("insert into stock (scontent,s_val,userid,s_volume,s_date) values(#{scontent},#{s_val},#{userid}, #{s_volume}, now())")
		public int sinsert(Map<String, Object> m);
	    
		@Select("select count(*) from stock")
		int count();
		

}
