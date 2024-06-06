package com.enok.board_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enok.board_back.entity.BoardListViewEntity;

@Repository
public interface BoardListViewRepository  extends JpaRepository<BoardListViewEntity, Integer>{
  
}
