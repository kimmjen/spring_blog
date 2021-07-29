package org.kimmjen.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(length = 100, nullable = false)
	private String title;
	
//	@Column(length = )
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html>태크가 섞여서 디자인이 됨
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne // 연관관계만들어준다. Board(Many) To User(One) 한명의 유저는 여러개의 게시글을 쓸 수 있다. <-> OneToMany
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	// user는 FK가 된다.
	
	@CreationTimestamp // 자동 값 입력
	private Timestamp createDate;

}
