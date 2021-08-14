package org.kimmjen.blog.service;


import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Transactional
	public void 회원수정(User user) { // 외부로부터 받은 user
		// 수정시에는 영속성 컨텍스트 내의 User 오브젝트를 영속화 시키고, 영속화된 User 오브젝트를 수정
		// select를 해서 User 오브젝트를 DB로부터 가져오는 이유는 영속화를 하기 위해서
		// 영속화를 하면 영속화된 오브젝트를 변경하게 되면 자동으로 DB에 업데이트 값을 자동으로 보내기 때문.
		
		User persistence = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistence.setPassword(encPassword);
		persistence.setEmail(user.getEmail());
		

		
		// 위와 같은 함수가 끝이나면 끝날때 회원 수정 함수 종료시라는 것은 서비스가 종료된다는 것과 같다.
		// 서비스 종료시는 트랜잭션이 종료 된다는 것이고 commit 이 자동으로 된다라는 의미.
		// commit이 자동으로 된다는 것은 영속화된 persistence객체의 변화가 감지되면 더티체킹이 되어 변환된 것들을 update문을 날려준다(자동으로)
		
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
