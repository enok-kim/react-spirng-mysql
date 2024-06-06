package com.enok.board_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enok.board_back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

  boolean existsByEmail(String email); // 메서드 이름 수정
  boolean existsByNickname(String nickname); // 메서드 이름 수정
  boolean existsByTelNumber(String telNumber); // 메서드 이름 수정
  
}
