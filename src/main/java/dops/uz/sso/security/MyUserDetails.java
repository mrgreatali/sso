package dops.uz.sso.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private Set<String> permissions;
    private Set<String> roles;
    private String role;

    public MyUserDetails() {
    }

    public MyUserDetails(String username, String password, Set<String> permissions, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.roles = roles;
    }

    public String getRole() {
        return role;
    }

    public MyUserDetails setRole(String role) {
        this.role = role;
        return this;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public MyUserDetails setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public MyUserDetails setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public MyUserDetails setPermissions(Set<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public MyUserDetails setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                ", roles=" + roles +
                ", role='" + role + '\'' +
                '}';
    }
}
