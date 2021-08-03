package org.kimmjen.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Bean 등록의 의미는 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것(IoC관리)
@Configuration
// requestController 실행되기 전에 securityconfig이 먼저 실행됨.
@EnableWebSecurity // 필터를 거는것= 스프링 시큐리티가 활성화 되어있는데, 어떤 설정을 해당 파일에서 관리하겠다 라는 뜻.
// 시큐리티 필터가 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근하면 권한및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// 해쉬(비밀번호)
	@Bean // IoC가 된다. new BCryptPasswordEncoder() 이것은 스프링이 관리한다.
	public BCryptPasswordEncoder encodePWD() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable() // csrf 토큰 비활성화(테스트할때)
			.authorizeRequests()
				.antMatchers("/","/auth/**", "/js/**", "/css/**", "/image/**") //접근
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/loginForm");
		
	}

}
