package dops.uz.sso.config;

import dops.uz.sso.security.MyUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class MyAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUsername(login);
        myUserDetails.setRole("ADMIN");
        Set<String> permissions = new HashSet<>();
        permissions.add("gg.wp");
        myUserDetails.setPermissions(permissions);
        System.out.println(login);
        System.out.println(password);
        if(login.equals("admin")){
            throw new UsernameNotFoundException("user is blocked");
        }
        return new UsernamePasswordAuthenticationToken(myUserDetails,"ADMIN",new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
