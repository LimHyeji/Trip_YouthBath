package com.ssafy.enjoytrip.board.model.repository;

import com.ssafy.enjoytrip.board.model.vo.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardVO,Long> {
}
