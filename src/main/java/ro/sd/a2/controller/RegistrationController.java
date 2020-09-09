package ro.sd.a2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.converters.UserToUserDTO;
import ro.sd.a2.dto.UserDTO;

import ro.sd.a2.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView mv = new ModelAndView();
        UserDTO user = new UserDTO();
        mv.addObject("user", user);
        mv.setViewName("/signup");
        return mv;
    }

    @PostMapping("/signup")
    public ModelAndView createUser(@Valid UserDTO user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();

        UserDTO emailExists = UserToUserDTO.convertUserToUserDTO(userService.findUserByEmail(user.getEmail()));
        UserDTO usernameExists = UserToUserDTO.convertUserToUserDTO(userService.findByUserName(user.getUsername()));

        if(emailExists != null) {
            bindingResult.rejectValue("email", "error.user.email", "This email already exists!");
        }
        if(usernameExists != null ){
            bindingResult.rejectValue("email", "error.user.username", "This email already exists!");
        }

        if(bindingResult.hasErrors()) {
            mv.setViewName("signup");
        } else {


            userService.saveUser(user);
            mv.addObject("msg", "User has been registered successfully!");
            mv.addObject("user", new UserDTO());
            mv.setViewName("signup");
        }

        return new ModelAndView("login");
    }
}
