package org.kimmjen.blog.service;


import org.kimmjen.blog.model.Board;
import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.repository.BoardRepository;
import org.kimmjen.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void 글쓰기(Board board, User user) { // title, content, count
		
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
}
