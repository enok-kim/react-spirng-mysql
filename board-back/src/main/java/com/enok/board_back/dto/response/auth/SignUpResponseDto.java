package com.enok.board_back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.enok.board_back.common.ResponseCode;
import com.enok.board_back.common.ResponseMessage;
import com.enok.board_back.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class SignUpResponseDto extends ResponseDto{

  public SignUpResponseDto() {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
  }//SIgnUpResponseDto

  public static ResponseEntity<SignUpResponseDto> success(){
    SignUpResponseDto result = new SignUpResponseDto();
    return ResponseEntity.status(HttpStatus.OK).body(result);
    }//ReponseEntity SignUpResponseDto

  public  static ResponseEntity<ResponseDto> duplicateEmail(){
    ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_EMAIL, ResponseMessage.DUPLICATE_EMAIL);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }//ResponseEntity REsponseDto Email

  public  static ResponseEntity<ResponseDto> duplicateNickName(){
    ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_NICKNAME, ResponseMessage.DUPLICATE_NICKNAME);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }//ResponseEntity REsponseDto NickName

  public  static ResponseEntity<ResponseDto> duplicateTelNumber(){
    ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_TEL_NUMBER, ResponseMessage.DUPLICATE_TEL_NUMBER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }//ResponseEntity REsponseDto TelNumber


  
}//class
