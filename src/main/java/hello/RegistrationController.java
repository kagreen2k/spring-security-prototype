package hello;

import static org.springframework.security.core.userdetails.User.withUsername;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController
{
  private static final Logger logger = Logger.getLogger(RegistrationController.class);

  private UserDetailsManager userDetailsManager;
  
  @Autowired
  public void setUserDetailsManager(UserDetailsManager userDetailsManager)
  {
    this.userDetailsManager = userDetailsManager;
  }
  
  @GetMapping("/registration")
  public String greetingForm(Model model) {
      model.addAttribute("user", new UserDto());
      return "registration";
  }


  @PostMapping("/register")
  public String registerUser(Model model, @ModelAttribute UserDto user) {
    
    logger.info("User registered: " + user);
    
    // TODO: is password encryption "out of the box" functionality 

    // TODO: valid username (email address) / password
    // TODO: check if user already exists
    
    
    UserDetails userDetails = withUsername(
      user.getEmailAddress()).password(user.getPassword()).authorities("ROLE_USER").build();
    
    userDetailsManager.createUser(userDetails);
    // TODO: figure out how to login and redirect to home or
//    model.addAttribute("user", user);

    // just redirect to login for now
    return "login";    
  }
  
}
