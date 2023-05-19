/*
   Date    : 2023.05.15
   name    : StockService
   type    : Service
   ver     : 1.1
   connect  : StockController
   content : 재고관리 서비스 클래스
   writer  : 이이지
   api     : x
  */
package stock_m.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import stock_m.dao.StockDao;
import stock_m.dto.StockDto;

@Service
public class StockService {
	@Autowired
	StockDao dao;
	//재고
	
	
	
		public List<StockDto> sList(String userid){
			return dao.sList(userid);
		}
		
		
		/* public int supdate(List<StockDto> dto) {
			return dao.supdate(dto);
		}*/
		
		public int sdelete(int sno) {
			return dao.sdelete(sno);
			
		}
		public List<StockDto> searchscontent(String search){
			return dao.searchscontent(search);
		}
		public int sinsert(String scontent, int s_val, String userid, int s_volume) {
			Map<String, Object> m = new HashMap<>();
			
			m.put("scontent", scontent);
			m.put("s_val", s_val);
			m.put("userid",userid);
			m.put("s_volume", s_volume);
			return dao.sinsert(m);
		}


		public int count() {
			// TODO Auto-generated method stub
			return dao.count();
		}


		/*public int stockupdate(List<StockDto> dto) {
		return dao.stockupdate(dto);			
		}*/


		/*public int stockupdate(int sno, int s_volume) {
             Map<String, Object> m = new HashMap<>();
			
			m.put("sno", sno);
			m.put("s_volume", s_volume);
			return dao.stockupdate(m);
			
		}*/


		 
		


		public int supdate(int sno, int s_volume) {
			System.out.println("this is service : "+sno+" /// "+s_volume);
			return dao.supdate(sno,s_volume);
			
		}
		


		
=======
import stock_m.dao.AdminstockDao;
import stock_m.dao.StockDao;
import stock_m.dto.AdminstockDto;

@Service
public class StockService {
	
	@Autowired
	StockDao dao;
	
	@Autowired
	AdminstockDao admindao;
	
	public List<AdminstockDto>option(){
		Map<String, Object> m =new HashMap<String, Object>();
		return admindao.option(m);
		
	}

	public void inserts(String scontent, int s_volume, String s_date) {
		dao.inserts(scontent,s_volume, s_date);
	}
>>>>>>> main
}
