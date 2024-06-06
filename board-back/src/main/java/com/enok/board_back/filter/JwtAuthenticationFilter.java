package com.enok.board_back.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import com.enok.board_back.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                try {
                    String token =  parseBearerToken(request);
                    if (token == null){
                      filterChain.doFilter(request, response);
                      return;
                    }//if
      
                    String email = jwtProvider.validate(token);
                    if (email == null){
                      filterChain.doFilter(request, response);
                      return;
                    }//if
      
                 AbstractAuthenticationToken authenticationToken = 
                 new UsernamePasswordAuthenticationToken(email, null, AuthorityUtils.NO_AUTHORITIES);
                 //인증 요청에 대한 세부정도 설정
                 authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              // 정보를 저장할 컨텍스트 생성
                 SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                 securityContext.setAuthentication(authenticationToken);
                 
                 SecurityContextHolder.setContext(securityContext);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //다음 필터로 넘기는 것
                filterChain.doFilter(request, response);
    }//doFilterInternal

    private String parseBearerToken(HttpServletRequest request){

        String authorization = request.getHeader("Authorization");
        //hasText는 널이거나 길이가 0이거나 공백일 때 폴스를 반환 해준다.
        boolean hasAuthorization = StringUtils.hasText(authorization);
        if(!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer");
        if(!isBearer) return null;

        String token = authorization.substring(7);
        return token;
        
    }//parseBearerToken
}