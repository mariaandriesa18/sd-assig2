package ro.sd.a2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.User;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserDetails> userUserDetailsConverter;


    @Autowired
    @Qualifier(value = "userToUserDetails")
    public void setUserUserDetailsConverter(Converter<User, UserDetails> userUserDetailsConverter) {
        this.userUserDetailsConverter = userUserDetailsConverter;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return userUserDetailsConverter.convert( user);
    }
}
