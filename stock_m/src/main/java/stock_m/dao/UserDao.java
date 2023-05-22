package stock_m.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import stock_m.dto.UserDto;


@Mapper
public interface UserDao {
	/*
	 * String idCheck(String id); int insertMem(UserDto dto); UserDto login(UserDto
	 * dto); int updateMem(UserDto dto); int deleteMem(String id);
	 */
	/*
	 * @Select("select userid, userpw ,gender,age,username,role,enabled from user")
	 * List<UserDto> memsInfo();
	 */
	

	@Select("select * from user where userid = #{userid}")
	UserDto findById(String userid);
	
	@Insert("insert into user values (#{userid}, #{userpw}, #{gender}, #{age}, #{username},#{role},#{enabled})")
	int insertUser(UserDto user);
	
	@Insert("INSERT INTO revenue(userid,revenuelimit,bsum,ssum,profit) values(#{userid}, 0, 0, 0, 0)")
	int insertRevenue(UserDto user);
}

