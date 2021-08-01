package org.kimmjen.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java(다른언어) Object를 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert // insert 시에 null인 필드를 제외
public class User {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	// 넘버링 전략
	private int id; // 시퀸스, auto_increment

	@Column(length = 30, nullable = false, unique = true)
	private String username; // 아이디
	@Column(length = 100, nullable = false) // 나중에 해쉬를 이용해 비밀번호 암호화
	private String password; // 비밀번호
	@Column(length = 50, nullable = false)
	private String email; //

	// @ColumnDefault("'user'") // " ' ' "
	// DB는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. 열걸, USER, MANAGER, ADMIN 1 ~80, 81 ~ 90, 91 ~ 100 이런 느낌

	@CreationTimestamp // 시간이 자동입력
	private Timestamp createDate; //
	// private Timestamp updateDate;

}
