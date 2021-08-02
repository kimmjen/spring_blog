package org.kimmjen.blog.controller.api;

import org.kimmjen.blog.dto.ResponseDto;
import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
	
//	@PostMapping("/api/user")
//	public int save(@RequestBody User user) {
//		
//		System.out.println("UserApiController : save 호출됨");
//		return 1;
//	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		System.out.println("UserApiController : save 호출됨");
		
		// 실제로 DB에 insert를 하고 아래에서 return 이 되면 된다.
		
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		// 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}

}