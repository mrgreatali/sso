package dops.uz.sso.config;

import dops.uz.sso.security.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("SecurityPermission")
public class SecurityPermission {
    public boolean hasPermission(String... permission) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("here we are ... " + Arrays.toString(permission));
        System.out.println(userDetails.toString());
      if (userDetails.getPermissions() != null) {
            return userDetails.getPermissions().containsAll(Arrays.asList(permission));
        } else return false;
    }
}