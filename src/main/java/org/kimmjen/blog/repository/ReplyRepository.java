package org.kimmjen.blog.repository;

import javax.transaction.Transactional;

import org.kimmjen.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	
//	@Transactional
	@Modifying
	@Query(value = "INSERT INTO reply(userId, boardId, content, createDate) VALUES(?1, ?2, ?3, noew())", nativeQuery = true)
//	void mSave(ReplySaveRequestDto replySaveRequestDto);
	int mSave(int userId, int boardId, String content); // 업데이트된 행의 개수를 리턴
	
//	@Modifying
//    @Query(value="INSERT INTO reply(content, boardId, userId, createDate) VALUES(?1, ?2, ?3, now())", nativeQuery = true)
//    void nativeInsertReply(String content, int boardId, int userId);
	
//	@Modifying
//    @Query(value="INSERT INTO reply(content, boardId, userId, createDate) VALUES(:content, :boardId, :userId, now())", nativeQuery = true)
//    int nativeInsertReply(String content, int boardId, int userId);
}
