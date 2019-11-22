package dops.uz.sso.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserDetailsImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        MyUserDetails user = new MyUserDetails().setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        user.setRole("ADMIN");
        if (!s.equals("admin")) {
            throw new UsernameNotFoundException("User not found.");
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
//        return user;
    }
}
