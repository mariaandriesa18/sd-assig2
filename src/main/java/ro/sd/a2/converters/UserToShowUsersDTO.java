package ro.sd.a2.converters;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import ro.sd.a2.dto.ShowUsersDTO;
import ro.sd.a2.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToShowUsersDTO {

    public static ShowUsersDTO convertUserToShowUsersDTO(User user){

        ShowUsersDTO s1 = new ShowUsersDTO();
        s1.setEmail(user.getEmail());
        s1.setName(user.getName());
        s1.setSurname(user.getSurname());
        s1.setBirthdate(user.getBirthdate());
        s1.setAddress(user.getAddress());
        return s1;
    }

    public static List<ShowUsersDTO> convertListOfUsersToListOfShowUsersDTO(List<User> userList){

        List<ShowUsersDTO> userDtoList = new ArrayList<>();
        for(User us : userList){
                userDtoList.add(convertUserToShowUsersDTO(us));
        }

        return  userDtoList;
    }

}
