/*
   Date    : 2023.05.15
   name    : RevenueDao
   type    : Dao
   ver     : 1.1
   connect  : RevenueService
   content : 판매,구매내역 장부관리 dao
   writer  : 이이지
   api     : x
  */
package stock_m.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;
import stock_m.dto.BuyDto;
import stock_m.dto.RevenueDto;
import stock_m.dto.SellDto;
import stock_m.dto.StockDto;

@Mapper
public interface RevenueDao {
	
	@Insert("insert into sell (sno,userid,pno,sdate,price,scount) values(#{sno},#{userid},#{pno},#{sdate},#{price},#{scount})")
	int insert(SellDto dto);
	
	@Select("select * from revenue where userid = #{'1'}")//글번호가 같다면 전부 select
	List<SellDto> selectOne(String userid);
	
    @Update("update sell set pno=#{pno}, price=#{price} where sno=#{sno} ") 
	 int updateRefOne(Map<String, Integer> snomap);
		
	@Delete ("delete from buy where bno = #{bno}")
	int deleteRef(@RequestParam int bno);
	
	@Select("select * from revenue where userid = #{'1'} order by rno ")
	List<RevenueDto> boardList(Map<String, Object> m);//start,count desc limit #{start} , #{count}
	
	@Select("select count(*) from sell")
	int count();
	
	
	@Insert("insert into sell (sno, pno, userid,sdate,price,scount) values(#{sno}, #{pno}, #{'1'}, now(),#{price} #{scount}")
	int rinsert(BuyDto dto);

	@Select("select s.sno,p.pname,DATE_FORMAT(s.sdate, \"%Y/%m/%d\")as sdate,s.price,s.scount from sell s,product p where s.pno=p.pno and userid=#{'1'}")
	List<Map<String, Object>> sellList(String userid);

	@Select("select * from sell where sno = #{sno}")//글번호가 같다면 전부 select
	SellDto selectsell(int sno);
    
	
	
	//@Update("update sell set price=#{price} where sno=#{sno}")
	//int updateSell(List<SellDto> dto);	
	
	//구매
	
	@Insert("insert into buy (bno, pno, userid, bdate, price) values(#{bno}, #{pno}, #{'1'}, now(), #{price})")
	int rbuyinsert(BuyDto dto);
	
	@Select("select b.bno,p.pname,DATE_FORMAT(b.bdate, \"%Y/%m/%d\") as bdate,b.price,b.bcount from buy b,product p where b.pno=p.pno and userid=#{'1'}")
	List<Map<String,Object>> rbuyList(String userid);
	
	@Update("update buy set price=#{price} where bno=#{bno}")
	int rbuyupdate(List<BuyDto> dto);	
	
	
	
	@Update("update sell set price=#{price} where sno=#{sno}")
	int updatesell(List<SellDto> dto);
	
	@Insert("insert into sell (userid,pno,price,sdate,scount) values(#{userid},#{pno},#{price},now(),#{scount})")
     int sellinsert(Map<String, Object> m);

	@Insert("insert into buy (userid,pno,price,bdate,bcount) values(#{userid},#{pno},#{price},now(),#{bcount})")
     int buyinsert(Map<String, Object> m);

	@Select("select pname from product, buy where buy.pno=product.pno and buy.pno={pno}")
    String selectpname(int pno);

	@Delete("delete from sell where sno=#{sno}")
	int deletesell(int sno);

	
	
	@Select("select s.sno as no, p.pname,DATE_FORMAT(s.sdate, \"%Y/%m/%d\") as 'date', p.price, s.scount as count ,'판매' as kind  from sell s, product p  where s.pno=p.pno union select b.bno as no, p.pname, DATE_FORMAT(b.bdate, \"%Y/%m/%d\") as 'date', p.price, b.bcount as count ,'구매' as kind  from buy b, product p  where b.pno=p.pno  and userid =#{'1'} order by date") 
	List<Map<String, Object>> totalList(String userid);

	@Select("select *from sell,buy where pname=#{search}")
	List<StockDto> searchrcontent(String search);
	 
	

	@Select("select `limit` from revenue where userid = 'testcompany'")
	int checks();
 
	//chart
	@Select("SELECT SUM(price) AS total_sell FROM sell where userid=#{userid} and sdate=#{sdate}")
	String totalsell(@Param("userid")String userid, @Param("sdate") String sdate);

	@Select("SELECT SUM(price) AS total_sell FROM sell WHERE sdate BETWEEN #{startDate} AND #{endDate}")
	int getFilteredData(@Param("startDate")String startDate, @Param("endDate") String endDate);

	@Select("SELECT SUM(price) AS total_sell FROM buy WHERE bdate BETWEEN #{startDate} AND #{endDate}")
	int getbuyData(@Param("startDate")String startDate, @Param("endDate")String endDate);
	
	@Select(" SELECT (SELECT SUM(price) FROM sell WHERE sdate BETWEEN #{startDate} AND #{endDate})-(SELECT SUM(price) FROM buy WHERE bdate BETWEEN #{startDate} AND #{endDate}) AS profit")
	int gettotalData(@Param("startDate")String startDate, @Param("endDate")String endDate);
	
	
	

}
