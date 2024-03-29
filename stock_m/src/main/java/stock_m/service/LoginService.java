package stock_m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import stock_m.dao.UserDao;
//import stock_m.dto.LoginRole;
import stock_m.dto.UserDto;

@Service
public class LoginService {
	@Autowired
	UserDao dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public int checkId(String userid) {
		return dao.checkId(userid);
	}
	
	public int insertUser(UserDto user) {
		
		//암호화(BCrypt 알고리즘 )
		user.setUserpw(encoder.encode(user.getUserpw()));	
		
		int i = dao.insertUser(user);
		if(user.getRole().toString().equals("ROLE_COMPANY")) {
			int l = dao.insertRevenue(user);
			System.out.println(l);
		}		
		System.out.println(i);
		
		return i;
	}
}
