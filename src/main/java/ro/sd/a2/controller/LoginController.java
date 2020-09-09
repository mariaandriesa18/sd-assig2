package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserDetailsImpl;


@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
/*
    @GetMapping("/profile")
    public ModelAndView showProfile() {
        //validation if needed
        //shall we log a little?
        ModelAndView mav = new ModelAndView();
        User user = new User("Bubu");
        mav.addObject("userObj", "bubu");
        mav.addObject("numeStudent","bubu");
        // adaugi x obiecte
        mav.setViewName("profile");
        //log the final outcome: Success y?
        return mav;
    }*/


    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/login")
    public String getLogin(){
       return "login";
   }

}
