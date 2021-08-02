package org.kimmjen.blog.service;

import javax.transaction.Transactional;

import org.kimmjen.blog.model.User;
import org.kimmjen.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해줌. IOC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int 회원가입(User user) {
		
		try {
			userRepository.save(user);
			
			return 1;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("UserService: 회원가입() : " + e.getMessage());
			
		}
		return -1;
	}
}
