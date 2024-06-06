package com.enok.board_back.entity;

import com.enok.board_back.entity.primaryKey.FavoritePK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "favorite")
@Table(name = "favorite")
@IdClass(FavoritePK.class) // 복합 key를 설정할 수 있음
public class FavoriteEntity {
  @Id
  private String userEmail;
  @Id
  private int boardNumber;
}
