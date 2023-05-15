package stock_m.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoginConfig{
	
	@Autowired
	private LoginUserDetailService loginUserDetailService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {	

		security.authorizeHttpRequests()
        .requestMatchers("/member/**").authenticated()
        .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().permitAll()
        .and().formLogin().loginPage("/login/login").defaultSuccessUrl("/loginSuccess", true)
        .and().exceptionHandling().accessDeniedPage("/accessDenied")
        .and().logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		security.userDetailsService(loginUserDetailService);
		security.csrf().disable();
		
		return security.build();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}