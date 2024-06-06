package com.enok.board_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enok.board_back.dto.request.auth.SignInRepuestDto;
import com.enok.board_back.dto.request.auth.SignUpRequestDto;
import com.enok.board_back.dto.response.ResponseDto;
import com.enok.board_back.dto.response.auth.SignInResponseDto;
import com.enok.board_back.dto.response.auth.SignUpResponseDto;
import com.enok.board_back.entity.UserEntity;
import com.enok.board_back.provider.JwtProvider;
import com.enok.board_back.repository.UserRepository;
import com.enok.board_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

  private final UserRepository userRepository;
  private final JwtProvider jwtProvider;

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
    
      try {

        String email = dto.getEmail();
        boolean existByEmail = userRepository.existsByEmail(email);
        if(existByEmail) return SignUpResponseDto.duplicateEmail();

        String nickname = dto.getNickname();
        boolean existByNickname = userRepository.existsByNickname(nickname);
        if(existByNickname) return SignUpResponseDto.duplicateNickName();

        String telNumber = dto.getTelNumber();
        boolean existByTelNumber = userRepository.existsByTelNumber(telNumber);
        if(existByTelNumber) return SignUpResponseDto.duplicateTelNumber();

        String password = dto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        dto.setPassword(encodedPassword);

        UserEntity userEntity = new UserEntity(dto);
        userRepository.save(userEntity); // DB에 저장

      } catch (Exception e) {
        e.printStackTrace();
        return ResponseDto.databaseError();
      }//catch
      return SignUpResponseDto.success();
  }//signUp

  @Override
  public ResponseEntity<? super SignInResponseDto> signIn(SignInRepuestDto dto) {

      String token = null; 

    try {

      String email = dto.getEmail();
      UserEntity userEntity = userRepository.findByEmail(email);
      if (userEntity == null) return SignInResponseDto.signInFaild();

      String password = dto.getPassword();
      String encodedPassword = userEntity.getPassword(); // 암호화 되어 있는 비밀번호
      boolean isMatched = passwordEncoder.matches(password, encodedPassword);
      if(!isMatched) return SignInResponseDto.signInFaild();

      //token을 만들어야 한다.
      token = jwtProvider.create(email);
      
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseDto.databaseError();
    }
    return SignInResponseDto.success(token);
  }//signIn
  
}//class