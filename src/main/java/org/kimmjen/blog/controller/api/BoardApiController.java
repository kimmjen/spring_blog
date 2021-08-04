package org.kimmjen.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.kimmjen.blog.config.auth.PrincipalDetail;
import org.kimmjen.blog.dto.ResponseDto;
import org.kimmjen.blog.model.Board;
import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.service.UserService;
import org.kimmjen.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	

	@PostMapping("/auth/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		
		boardService.글쓰기(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

	}

}
