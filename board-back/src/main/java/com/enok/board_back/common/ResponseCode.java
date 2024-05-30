package com.enok.board_back.common;

public interface ResponseCode {
  
  //HTTP Status 200
  public static final String SUCCESS = "SU";

  //검증 실패
  //HTTP Status 400
  String VALLIDATION_FAILED = "VF";
  String DUPLICATE_EMAIL = "DE";
  String DUPLICATE_NICKNAME = "DN";
  String DUPLICATE_TEL_NUMBER = "DT";
  String NOT_EXISITED_USER = "NU";
  String NOT_EXISITED_BOARD = "NB";

  //HTTP status 401
  String SIGN_IN_FAIL = "SF";
  String AUTHORIZATION_FAIL = "AF";

  //HTTP Status 403
  String NO_PERMISSION = "NP";

  //HTTP Status 500
  String DATABASE_ERROR = "DE";
  
}