package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.sd.a2.converters.UserToShowUsersDTO;
import ro.sd.a2.dto.ShowUsersDTO;
import ro.sd.a2.dto.UserDTO;
import ro.sd.a2.entity.User;
import ro.sd.a2.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service("userService")

public class UserService extends UserDetailsImpl{

    @Autowired
    private UserRepository urepo ;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findByUserName(String name){
        return urepo.findUserByUsername(name);
    }


     public List<ShowUsersDTO> getAllUsers(){
        return UserToShowUsersDTO.convertListOfUsersToListOfShowUsersDTO(urepo.findAllRegularUsers());
    }


    public User findUserByEmail(String email){
        return urepo.findByEmail(email);
    }

@Transactional
    public void saveUser(UserDTO userDTO){
        User user = new User();
        user.setUser_id(UUID.randomUUID().toString());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRegistration_date();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setAddress(userDTO.getAddress());
         user.setRole("user");
         user.setBirthday_date(userDTO.getBirthdate());
         user.setAge();

         urepo.save(user);

    }



}
