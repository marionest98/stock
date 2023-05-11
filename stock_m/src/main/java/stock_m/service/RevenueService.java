package stock_m.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import stock_m.dao.RevenueDao;
import stock_m.dto.BuyDto;
import stock_m.dto.RevenueDto;
import stock_m.dto.SellDto;

@Service
public class RevenueService {
	@Autowired
	RevenueDao dao;
	
	
	public int insert(RevenueDto dto) {
           return dao.insert(dto);//dao에 추가
		}	
	public List<RevenueDto> selectOne(String userid) {
		return dao.selectOne(userid);
	}
	  
	 // public int updateRefOne(SellDto dto) { 
		//  return dao.updateRefOne(dto); }
	 
	public int deleteRef(int sno) {
		return dao.deleteRef(sno);
	}
    
	public List<RevenueDto> boardList(int start){
		Map<String,Object> m= new HashMap<String, Object>();
		m.put("start", start);
		m.put("count", 10);
		return dao.boardList(m);
	}
	public int count() {
		return dao.count();
	}
	public List<SellDto> sellList(String userid){
		
		return dao.sellList(userid);
	}
	public List<BuyDto> buyList(String userid){
		
		return dao.buyList(userid);
	}
	
	public SellDto selectsell(int sno) {
		
		return dao.selectsell(sno);
	}
	public int updateRefOne(Map<String, Integer> snomap) {
		  return dao.updateRefOne(snomap);
		
	}
	
	
	
}
