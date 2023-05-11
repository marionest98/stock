package stock_m.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import stock_m.dto.BuyDto;
import stock_m.dto.RevenueDto;
import stock_m.dto.SellDto;

@Mapper
public interface RevenueDao {
	@Insert("insert into revenue (userid, rlimit, bsum,ssuum, profit,margine) values(#{userid}, #{rlimit}, #{bsum}, #{ssuum}, #{profit}, #{margine})")
	int insert(RevenueDto dto);
	
	@Select("select * from revenue where userid = #{'1'}")//글번호가 같다면 전부 select
	List<RevenueDto> selectOne(String userid);
	
    @Update("update sell set pno=#{pno}, price=#{price} where sno=#{sno} ") 
	 int updateRefOne(Map<String, Integer> snomap);
		
	@Delete ("delete from sell where sno = #{sno}")
	int deleteRef(@RequestParam int sno);
	
	@Select("select * from revenue where userid = #{'1'} order by rno ")
	List<RevenueDto> boardList(Map<String, Object> m);//start,count desc limit #{start} , #{count}
	
	@Select("select count(*) from revenue")
	int count();
	
	@Insert("insert into buy (bno, pno, userid,bdate, price) values(#{bno}, #{pno}, #{'1'}, now(), #{price})")
	int binsert(SellDto dto);
	
	@Insert("insert into sell (sno, pno, userid,sdate,price) values(#{sno}, #{pno}, #{'1'}, now(),#{price})")
	int rinsert(BuyDto dto);

	@Select("select * from sell where userid = #{'1'}")
	List<SellDto> sellList(String userid);
	
	@Select("select * from buy where userid = #{'1'}")
	List<BuyDto> buyList(String userid);

	@Select("select * from sell where sno = #{sno}")//글번호가 같다면 전부 select
	SellDto selectsell(int sno);
    
	@Update("update sell set price=#{price} where sno=#{sno} ") 
	SellDto updatesellpri(int price);

	@Update("update sell set pno=#{pno} where sno=#{sno} ") 
	SellDto updatesellp(int pno);

	

	
	
	
	
	
}
