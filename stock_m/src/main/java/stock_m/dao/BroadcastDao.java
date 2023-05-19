package stock_m.dao;

<<<<<<< HEAD

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import stock_m.dto.BroadcastLimitDto;
import stock_m.dto.BroadcastPriceDto;
import stock_m.dto.ProductDto;
=======
import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
>>>>>>> main



@Mapper
public interface BroadcastDao {
<<<<<<< HEAD
	/*
	 * //한도 알림 //한도 입력
	 * 
	 * @Insert("insert into `limit broadcast`(userid, limit) values(#{userid}, #{limit})"
	 * )
	 * 
	 * @Options(useGeneratedKeys = true, keyProperty = "lbrno")//글번호 dto 에저장 int
	 * insert(BroadcastLimitDto dto);
	 */
	//한도 수정
	/*
	 * @Select("select * from `limit broadcast` where userid= #{userid}")
	 * BroadcastLimitDto boardOne(String userid);
	 */
	
	/*
	 * @Update("update `limit broadcast` set userid=#{userid} where limit=#{limit} "
	 * ) int updateBoardcastlimit(BroadcastLimitDto dto);
	 * 
	 * //한도 비교
	 * 
	 * @Select("select limit from `limit broadcast` where userid = #{userid}") int
	 * broadcastlimit(String userid);
	 * 
	 * @Select("select limit from revenue where userid = #{userid}") int
	 * revenuelimit(String userid); //가져올것 int limit
	 */
	  //가격 알림 //가격 입력
	  
	  @Insert("insert into `price broadcast`(userid,br_search,br_param) values(#{userid},#{br_search},#{br_param})")  
	  int priceinsert(@Param("userid")String userid,@Param("br_search")int br_search,@Param("br_param")int br_param);
	  
	  //가격 수정
	  
		
	  @Select("select * from `price broadcast` where  userid= #{userid}")
	   BroadcastPriceDto priceselect(String userid);
		  
      @Update("update `price broadcast` set userid=#{userid} where br_search=#{br_search} and br_param=#{br_param}") 
      int priceupdate(BroadcastPriceDto dto);
		  
			
			  //가격 비교
			  
			  @Select("select br_search from `price broadcast` where userid = #{userid}") 
			  int brsearch(String userid);
			  
			  @Select("select br_param from `price broadcast` where userid = #{userid}") 
			  int brparam(String userid);
			 
			  @Select("select pno from product where userid = #{userid}")
			  int pno(String userid);
			  
			  @Select("select price from product where userid = #{userid}")
			  int price(String userid);
			 
	/*
	 * @Delete("delete from product where pno = #{pno}") int deleteBoard(int pno);
	 */
=======
	
	@Select("select userid from pricebroadcast where pno = #{pno} AND param <= #{param}")
	public List<String> broadPriceCheck(@Param("pno")int pno, @Param("param")int param);
	
	
>>>>>>> main
}
