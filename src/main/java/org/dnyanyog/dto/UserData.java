package org.dnyanyog.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class UserData {

  @NotNull
  @Min(8)
  private String username;

  @Size(min = 8, max = 16)
  @NotNull
  private String password;

  @Email @NotNull private String email;

  @Digits(fraction = 0, integer = 0)
  private String age;

  @NotNull private String userId;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
