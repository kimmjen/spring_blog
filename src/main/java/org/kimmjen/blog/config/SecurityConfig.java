package org.kimmjen.blog.config;

import org.kimmjen.blog.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean // IoC가 되요!!
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	// 시큐리티가 대신 로그인해주는데 password를 가로채기를 하는데
	// 해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
	// 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()  // csrf 토큰 비활성화 (테스트시 걸어두는 게 좋음)
			.authorizeRequests()
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/"); // 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
	}
//	@Autowired
//	private PrincipalDetailService principalDetailService;
//	
//	// 해쉬(비밀번호)
//	@Bean // IoC가 된다. new BCryptPasswordEncoder() 이것은 스프링이 관리한다.
//	public BCryptPasswordEncoder encodePWD() {
//		
//		return new BCryptPasswordEncoder();
//	}
//	
//	// 시큐리티가 대신 로그인해주는데 password를 가로채기를 하는데
//	// 해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
//	// 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//		.csrf().disable() // csrf 토큰 비활성화(테스트할때)
//			.authorizeRequests()
//				.antMatchers("/","/auth/**", "/js/**", "/css/**", "/image/**") //접근
//				.permitAll()
//				.anyRequest()
//				.authenticated()
//			.and()
//				.formLogin()
//				.loginPage("/auth/loginForm")
//				.loginProcessingUrl("/auth/loginProc") // 스프링시큐리티가 해당 주소로 요청오는 로그인을 가로챈다.
//				.defaultSuccessUrl("/"); //로그인 성공시
////				.failureUrl(null) 로그인실패시
//		
//	}

}
