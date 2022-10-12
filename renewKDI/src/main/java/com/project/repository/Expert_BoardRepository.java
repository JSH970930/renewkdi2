package com.project.repository;






import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.Expert_BoardRequestDto;
import com.project.entity.Expert_Board;




@Repository
public interface Expert_BoardRepository extends JpaRepository<Expert_Board, Long> {
	
	
	
	static final String UPDATE_BOARD = "UPDATE expert_board "
			+ "SET TITLE = :#{#boardRequestDto.title}, "
			+ "CONTENT = :#{#boardRequestDto.content}, "
			+ "REGISTER_ID = :#{#boardRequestDto.registerId}, "
			+ "UPDATE_TIME = SYSDATE() "
			+ "WHERE EXPERT_ID = :#{#boardRequestDto.id}";
			
	
	static final String UPDATE_BOARD_READ_CNT_INC = "UPDATE expert_board "
			+ "SET READ_CNT = READ_CNT + 1 "
			+ "WHERE EXPERT_ID = : id";
	
	static final String DELETE_BOARD = "DELETE FROM expert_board "
			+ "WHERE EXPERT_ID IN (:deleteList)";
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	public int updateBoard(@Param("boardRequestDto") Expert_BoardRequestDto boardRequestDto);
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD_READ_CNT_INC, nativeQuery = true)
	public int updateBoardReadCntInc(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = DELETE_BOARD, nativeQuery = true)
	public int deleteBoard(@Param("deleteList") Long[] deleteList);
	

	 





	

public Page<Expert_Board> findByTitleContaining(Pageable pageable, String searchKeyword);












}
