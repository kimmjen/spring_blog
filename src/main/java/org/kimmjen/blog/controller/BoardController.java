package org.kimmjen.blog.controller;

import org.kimmjen.blog.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
//	
//	@Autowired
//	private PrincipalDetail principal;

	// @AuthenticationPrincipal PrincipalDetail principal
//    @GetMapping({"","/"})
//    public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러에서 principalDetail session 어떻게 찾나?
//    	// WEB-INF/views/index
//    	
//    	System.out.println("로그인 사용자 아이디: " + principal.getUsername());
//        return "index";
//    }
    @GetMapping({"","/"})
    public String index() { // 컨트롤러에서 principalDetail session 어떻게 찾나?
    	// WEB-INF/views/index
    	
    	
        return "index";
    }
    // User 권한 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
    	
    	return "board/saveForm";
    }
}
