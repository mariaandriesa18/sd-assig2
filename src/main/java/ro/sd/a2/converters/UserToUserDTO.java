package ro.sd.a2.converters;

import org.springframework.stereotype.Component;
import ro.sd.a2.dto.UserDTO;
import ro.sd.a2.entity.User;

@Component
public class UserToUserDTO {

    public static UserDTO convertUserToUserDTO(User user){

        if(user != null) {
          UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setSurname(user.getSurname());
            userDTO.setAddress(user.getAddress());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setBirthdate(user.getBirthdate());
            userDTO.setUsername(user.getUsername());
            return userDTO;
        }

        return null;

    }



}
