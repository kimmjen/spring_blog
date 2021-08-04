package org.kimmjen.blog.repository;

import java.util.Optional;

import org.kimmjen.blog.model.Board;
import org.kimmjen.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// DAO
// 자동으로 bean등록이 된다
// @Repository // 생략가능하다.
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
}
