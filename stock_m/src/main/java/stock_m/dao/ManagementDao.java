/*
   Date    : 2023.05.11
   name    : management
   type    : java
   ver     : 1.1
   conect  : managementDao
   content : 회사 유의 업체 구분 변경
   writer  : 고상원
   api     : x
  */

package stock_m.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import stock_m.dto.ManagementDto;
import stock_m.dto.UserDto;
// db에 접근하기 위한 객체 생성 
@Mapper
public interface ManagementDao {

		int count();
		int countSearch(String keyword);
		int insert(String userid, String id);
		int insert2(String userid, String id);
		int find(@Param("m_content")String m_content,@Param("userid") String userid);
		int delete(int find); // insert,update,delete는 리턴 값 int
		int count1();
		int check(String id);
		int update(@Param("m_content")String m_content,@Param("userid") String userid);
		int update2(@Param("m_content")String m_content,@Param("userid") String userid);
		boolean check2(@Param("m_content")String m_content,@Param("userid") String userid);
		List<ManagementDto>managementList(Map<String,Object> m);
		List<ManagementDto>maList(Map<String,Object> m);
		List<UserDto> UserList(Map<String, Object> m);
		List<UserDto> UList(Map<String, Object> m);
		List<ManagementDto> mainList(Map<String, Object> m);
		boolean switch1(String m_content);
		
		
		
		

}
