package org.kimmjen.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	// auth 붙이는 이유 : 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
	// 그녕 주소가 / 이면 index.jsp 허용
	// static 이하에 있는 /js/**, /css/**, /image/**
	@GetMapping("auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}

}
