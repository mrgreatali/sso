package dops.uz.sso.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @PreAuthorize("@SecurityPermission.hasPermission('gg.wp')")
    @GetMapping("/emp/info")
    public Principal user(Principal principal) {
        return principal;
    }
}
