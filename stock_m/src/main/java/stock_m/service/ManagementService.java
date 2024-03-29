/*
   Date    : 2023.05.11
   name    : management
   type    : java
   ver     : 1.1
   conect  : managementService
   content : 회사 유의 업체 구분 변경
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
//dao(bean)객체에 mapper를 이용해 받아온 값들을 저장
@Service
public class ManagementService {
	@Autowired
	ManagementDao dao;

	public List<ManagementDto> managementList(int start, String keyword, String userid) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", start);
		m.put("count", 5);
		m.put("keyword", keyword);
		m.put("userid", userid);
		return dao.managementList(m);
	}

	public List<ManagementDto> mainList(int startRow, String userid) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("userid", userid);
		m.put("count", 3);
		m.put("startRow", startRow);
		return dao.mainList(m);
	}
	
	public List<ManagementDto> mainList2(int startRow, String userid) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("userid", userid);
		m.put("count", 10);
		m.put("startRow", startRow);
		return dao.mainList2(m);
	}
	public List<ManagementDto> maList(int start, String userid) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", start);
		m.put("count", 5);
		m.put("userid", userid);
		return dao.maList(m);
	}

	public int countSearch(String keyword) {
		return dao.countSearch(keyword);
	}

	public int insert(String userid, String username, String c_userid) {
		return dao.insert(userid,username,c_userid);

	}

	public int insert2(String userid,String id, String c_userid) {
		return dao.insert2(userid,id,c_userid);
	}

	public int find(String m_content, String userid) {
		return dao.find(m_content, userid);
	}

	public int delete(int mno, String userid) {
		Map<String, Object> m = new HashMap<>();
		m.put("mno", mno);
		m.put("userid", userid);
		return dao.delete(m);
	}

	public int count() {
		return dao.count();
	}

	public List<UserDto> UserList(int startRow, String keyword) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", startRow);
		m.put("count", 5);
		m.put("keyword", keyword);
		return dao.UserList(m);
	}

	public List<UserDto> UList(int startRow) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", startRow);
		m.put("count", 5);
		return dao.UList(m);
	}

	public int count1() {
		return dao.count1();
	}

	
	public int check(String username,String userid) {
		return dao.check(username, userid);
	}
	

	public int update(String m_content, String userid) {
		return dao.update(m_content, userid);
	}
	

	public int update2(String m_content, String userid) {
		return dao.update2(m_content, userid);
	}

	public boolean check2(String m_content, String userid) {
		return dao.check2(m_content, userid);
	}

	public boolean switch1(String m_content) {
		return dao.switch1(m_content);
	}

	public List<ManagementDto> managementListall(int startRow, String userid) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", startRow);
		m.put("count", 5);
		m.put("userid", userid);
		return dao.managementListall(m);
	}

}
