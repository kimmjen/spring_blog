package org.kimmjen.blog.service;


import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해줌. IOC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword(); //1234 원문
		String encPassword = encoder.encode(rawPassword); // 해쉬
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
//		t
	
//	@Transactional
//	public void 회원가입(User user) {
//		userRepository.save(user);
//	}
	
	
//		try {
//			userRepository.save(user);
//			
//			return 1;
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			System.out.println("UserService: 회원가입() : " + e.getMessage());
//			
//		}
//		return -1;
	
//	@Transactional(readOnly = true) // select 할때 트랜잭션 시작, 서비스 종료될 때 트랜잭션 종료(정합성 유지)
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
//	//@Transactional
//	// public User 로그인(User user) {
//	//	return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	//}
}
