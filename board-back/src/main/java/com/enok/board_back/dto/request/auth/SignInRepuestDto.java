package com.enok.board_back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInRepuestDto {
  @NotBlank
  private String email;
  @NotBlank
  private String password;
}
