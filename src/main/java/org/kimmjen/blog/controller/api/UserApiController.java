package org.kimmjen.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.kimmjen.blog.config.auth.PrincipalDetail;
import org.kimmjen.blog.dto.ResponseDto;
import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	// 
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {// username, password, email
		
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return 이 되면 된다.
		
//		String encPassword = 
		
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		// 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	@PutMapping("/user")
	// RequestBody를 쓰는이유는 json 파일이용하기 때문에 requestbody가 없으면 key=value값만, x-www-form-urlencoded
	public ResponseDto<Integer> update(@RequestBody User user) {
		
		userService.회원수정(user);
		// 트랜잭션이 종료되기 때문에 DB에 값은 변경 되었으나 세션값은 변경되지 않은 상태이기 때문에 직접 session 값설정을 해줘야한다.
		// 세션값 변경 방법.
		
		// 세션등록
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		// 강제로 세션값 변경해줌 아래 코드
//		Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
//		SecurityContext securityContext = SecurityContextHolder.getContext();
//		securityContext.setAuthentication(authentication);
//		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//		
//		
	}

//	@PostMapping("/api/user")
//	public int save(@RequestBody User user) {
//		
//		System.out.println("UserApiController : save 호출됨");
//		return 1;
//	}
//	@Autowired
//	private HttpSession session;
	
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//		
//		System.out.println("UserApiController : login 호출됨");
//		
//		User principal = userService.로그인(user); // principal(접근주체)
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
}
