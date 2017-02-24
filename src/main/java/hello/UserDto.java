package hello;

public class UserDto
{
  public static final UserDto ANONYMOUS_USER = new UserDto(
      "anonymous@anonymous.com", "password", "password");

  private String emailAddress;
  private String password;
  private String passwordConfirm;

  public UserDto() {
    
  }
  
  public UserDto(String emailAddress, String password, String passwordConfirm)
  {
    this.emailAddress = emailAddress;
    this.password = password;
    this.passwordConfirm = passwordConfirm;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPasswordConfirm()
  {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm)
  {
    this.passwordConfirm = passwordConfirm;
  }

  @Override
  public String toString()
  {
    return "UserDto [emailAddress=" + emailAddress + ", password=" + password
        + ", passwordConfirm=" + passwordConfirm + "]";
  }

  
}
