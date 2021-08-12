package org.kimmjen.guest;

import org.kimmjen.blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardMemberTest {
	
	@Autowired
	private BoardRepository boardRepository;


}
