/*
   Date    : 2023.05.06
   name    : management
   type    : java
   ver     : 1.0
   conect  : managementService
   content : 유의 업체 받아올 정보 형태
   writer  : 고상원
   api     : x
  */

package stock_m.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock_m.dao.ManagementDao;
import stock_m.dto.ManagementDto;
import stock_m.dto.UserDto;

@Service
public class ManagementService {
	@Autowired
	ManagementDao dao;
		
	public List<ManagementDto> managementList(int start, String keyword){
		Map<String, Object> m =new HashMap<String,Object>();
		m.put("start", start);
		m.put("count", 5);
		m.put("keyword", keyword);
		return dao.managementList(m);
	}

	
	public int countSearch(String keyword) {
		return dao.countSearch(keyword);
	}


	
	  public int insert(String id) { 
		  return dao.insert(id);
	  
	 }
	  
	 public int find(String m_content) {
		 return dao.find(m_content);
	 }
	 
	  public int delete(int mno) {
		  return dao.delete(mno);
	  }

	public List<UserDto> UserList(int startRow, String keyword) {
		Map<String, Object> m =new HashMap<String,Object>();
		m.put("start", startRow);
		m.put("count", 5);
		m.put("keyword", keyword);
		return dao.UserList(m);
	}
	 



}
