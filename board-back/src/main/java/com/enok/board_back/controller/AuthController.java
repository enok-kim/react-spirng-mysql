package com.enok.board_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enok.board_back.dto.request.auth.SignInRepuestDto;
import com.enok.board_back.dto.request.auth.SignUpRequestDto;
import com.enok.board_back.dto.response.auth.SignInResponseDto;
import com.enok.board_back.dto.response.auth.SignUpResponseDto;
import com.enok.board_back.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/sign-up")
  public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody){

    ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
    return response;

  }//signUp

  @PostMapping("/sign-in")
  public ResponseEntity<? super SignInResponseDto> signIn(@RequestBody @Valid SignInRepuestDto requestBody){
    ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
    return response;
  }//signIn

}//class
