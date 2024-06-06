package com.enok.board_back.dto.request.auth;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {

  @NotBlank//널이 아니여야하고 빈 문자가 아니고 공백으로 이뤄지면 안된다.
  @Email
  private String email;

  @NotBlank @Size(min = 8, max = 20)
  private String password;

  @NotBlank
  private String nickname;

  @NotBlank @Pattern(regexp = "^[0-9]{11-13}$") // 0부터 9까지의 숫자로 11-13자리의 숫자
  private String telNumber;

  @NotBlank
  private String address;

  private String addressDetail;

  @NotNull @AssertTrue // True만 올 수 있다.
  private Boolean agreedPersonal;

}