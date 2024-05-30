package com.enok.board_back.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.enok.board_back.filter.*;;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig {

  private final JwtAuthentication
  
}
