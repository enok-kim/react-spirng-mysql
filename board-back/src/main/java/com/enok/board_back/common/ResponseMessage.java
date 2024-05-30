package com.enok.board_back.common;

public interface ResponseMessage {
  public static final String SUCCESS = "Success.";

  //검증 실패
  //HTTP Status 400
  String VALLIDATION_FAILED = "Validation failed.";
  String DUPLICATE_EMAIL = "Duplicate email.";
  String DUPLICATE_NICKNAME = "Duplicate nickname.";
  String DUPLICATE_TEL_NUMBER = "Duplicate tel number.";
  String NOT_EXISITED_USER = "This user does not exist.";
  String NOT_EXISITED_BOARD = "This board does not exist.";

  //HTTP status 401
  String SIGN_IN_FAIL = "Login information mismatch.";
  String AUTHORIZATION_FAIL = "Authorization Failed.";

  //HTTP Status 403
  String NO_PERMISSION = "Do not have permission.";

  //HTTP Status 500
  String DATABASE_ERROR = "Database error.";
}
