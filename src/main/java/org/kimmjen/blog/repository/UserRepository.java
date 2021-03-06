package org.kimmjen.blog.repository;

import java.util.Optional;

import org.kimmjen.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// DAO
// 자동으로 bean등록이 된다
// @Repository // 생략가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {

	// SELECT * fROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
	
}

// 시큐리티 적용전 버전
//JPA 네이밍 쿼리
	// SELECT * FROM user WHERE username = ?1 AND password = ?2; 
	// User findByUsernameAndPassword(String username, String password);
	
	//	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
	//	User login(String username, String password);