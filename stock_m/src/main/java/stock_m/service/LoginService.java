package stock_m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import stock_m.dao.UserDao;
import stock_m.dto.LoginRole;
import stock_m.dto.UserDto;

@Service
public class LoginService {
	@Autowired
	UserDao dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public int insertUser(UserDto users) {
		
		//암호화(BCrypt 알고리즘 )
		users.setUserpw(encoder.encode(users.getUserpw()));
	
		users.setRole(LoginRole.ROLE_ADMIN);
		
		int i = dao.insertUser(users);
		System.out.println(i);
		
		return i;
	}
}
