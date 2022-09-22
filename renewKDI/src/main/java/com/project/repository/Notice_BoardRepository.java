package com.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.Notice_BoardRequestDto;
import com.project.entity.Notice_Board;

@Repository
public interface Notice_BoardRepository extends JpaRepository<Notice_Board, Long> {
	
	Page<Notice_Board> findByTitleContaining(Pageable pageable, String searchKeyword);
	
	static final String UPDATE_BOARD = "UPDATE notice_board "
			+ "SET TITLE = :#{#boardRequestDto.title}, "
			+ "CONTENT = :#{#boardRequestDto.content}, "
			+ "REGISTER_ID = :#{#boardRequestDto.registerId}, "
			+ "UPDATE_TIME = SYSDATE() "
			+ "WHERE ID = :#{#boardRequestDto.id}";
			
	
	static final String UPDATE_BOARD_READ_CNT_INC = "UPDATE notice_board "
			+ "SET READ_CNT = READ_CNT + 1 "
			+ "WHERE ID = : id";
	
	static final String DELETE_BOARD = "DELETE FROM notice_board "
			+ "WHERE ID IN (:deleteList)";
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	public int updateBoard(@Param("boardRequestDto") Notice_BoardRequestDto boardRequestDto);
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD_READ_CNT_INC, nativeQuery = true)
	public int updateBoardReadCntInc(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = DELETE_BOARD, nativeQuery = true)
	public int deleteBoard(@Param("deleteList") Long[] deleteList);
	
	
	
}
