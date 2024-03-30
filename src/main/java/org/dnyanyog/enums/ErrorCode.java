package org.dnyanyog.enums;

public enum ErrorCode {
  VALIDATION_SUCCESS("Success", "Login successful"),
  VALIDATION_FAIL("Fail", "Username & Password Do Not Match"),
  USERNAME_NOTFOUND("Fail", "User with the provided username is not found in the database"),
  LOGIN_ERROR("Error", "An error occurred during login"),

  USER_ADD_SUCCESS("Success", "User added successfuly"),
  USER_FOUND("Success", "User found"),
  USER_NOTFOUND("Fail", "User not found");

  private final String status;
  private final String message;

  ErrorCode(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
