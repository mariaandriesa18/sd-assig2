package ro.sd.a2.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserDetailsImpl;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {

        UserDetailsImpl userDetails = new UserDetailsImpl();

        if (user != null) {
            userDetails.setUsername(user.getUsername());
            userDetails.setPassword(user.getPassword());
            userDetails.setEnabled(true);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            userDetails.setAuthorities(authorities);
        }

        return userDetails;
    }
}