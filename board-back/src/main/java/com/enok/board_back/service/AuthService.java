package com.enok.board_back.service;

import org.springframework.http.ResponseEntity;

import com.enok.board_back.dto.request.auth.SignUpRequestDto;
import com.enok.board_back.dto.response.auth.SignUpResponseDto;

public interface AuthService {

  ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
  
}
