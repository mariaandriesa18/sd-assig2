package ro.sd.a2.converters;

import org.springframework.stereotype.Component;
import ro.sd.a2.dto.UserDTO;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserService;

@Component
public class DTOtoEntity {

    private UserService userService;
    public DTOtoEntity(){}

    public User convertUserDTOtoUser(UserDTO userDTO){
        User user = new User();
        user = userService.findByUserName(userDTO.getUsername());
        return user;
    }
}
