package stock_m.service;


import java.util.Map;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock_m.dao.BroadcastDao;

import stock_m.dto.BroadcastLimitDto;
import stock_m.dto.BroadcastPriceDto;
import stock_m.dto.ProductDto;
import stock_m.dto.RevenueDto;



@Service
public class BroadcastService {
	
	@Autowired

	BroadcastDao dao;
	/*
	 * public int insert(BroadcastLimitDto dto) { return dao.insert(dto); } public
	 * int updateBoardcastlimit(BroadcastLimitDto dto) { return
	 * dao.updateBoardcastlimit(dto); }
	 */
	
	/*
	 * public BroadcastLimitDto boardOne(String userid) { //dao.addReadcount(lbrno);
	 * return dao.boardOne(userid); }
	 */
	
	/*
	 * public int broadcastlimit(String userid) { //dao.addReadcount(lbrno); return
	 * dao.broadcastlimit(userid); } public int revenuelimit(String userid) {
	 * //dao.addReadcount(lbrno); return dao.revenuelimit(userid); }
	 */
	  // 가격 알림
	  
	  // 가격 입력 
	public int priceinsert(String userid,int br_search,int br_param){ 
		return dao.priceinsert(userid,br_search,br_param); }
	  

  //가격 수정 
	public BroadcastPriceDto priceselect(String userid){ 
		return dao.priceselect(userid); }
  
  public int priceupdate(BroadcastPriceDto dto) { 
	  return dao.priceupdate(dto);}
  
	
	  //가격 비교 
  public int brsearch(String userid){ 
	  return dao.brsearch(userid); } 
  public int brparam(String userid){ 
	  return dao.brparam(userid); }
	  public int pno(String userid) {
		  return dao.pno(userid);  
	  }
	  public int price(String userid){
		  return dao.price(userid);
		  
	  }	 
	 
	/*
	 * public int deleteBoard(int pno) { return dao.deleteBoard(pno); }
	 */

	BroadcastDao Broadcast_dao;
	
	public List<String> broadPriceCheck(int pno, int param){
		
		List<String> userList =  Broadcast_dao.broadPriceCheck(pno,param);
		
		return userList;
	}

	
}
