package org.kimmjen.blog.controller;

import org.kimmjen.blog.config.auth.PrincipalDetail;
import org.kimmjen.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
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
	@GetMapping({ "", "/" })
	public String index(Model model,
			@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) { // 컨트롤러에서
																											// principalDetail																											// session
																										// 어떻게 찾나?

		model.addAttribute("boards", boardService.글목록(pageable));
		// WEB-INF/views/index
		return "index";
	}

//    @GetMapping("/board/{id}")
//    public String findById(@PathVariable int id) {
//    	boardService.글상세보기(id);
//    }
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));

		return "board/detail";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/updateForm";
	}

	// User 권한 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {

		return "board/saveForm";
	}

	// User 권한 필요
//    @GetMapping("/board/list")
//    public String list(Model model, @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//    	
//    	model.addAttribute("boards", boardService.글목록(pageable));
//    	return "board/list";
//    }
}
