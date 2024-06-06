package com.enok.board_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
@Table(name = "board")
public class BoardEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성과 관련된 어노테이션
  private int boardNumber;
  private String title;
  private String content;
  private String writeDatetime;
  private int favoiteCount;
  private int commentCount;
  private int viewCount;
  private String writerEmail;
}