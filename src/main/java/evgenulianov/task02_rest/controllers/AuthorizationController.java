package evgenulianov.task02_rest.controllers;

import evgenulianov.task02_rest.service.Authorities;
import evgenulianov.task02_rest.service.AuthorizationService;
import evgenulianov.task02_rest.service.InvalidCredentials;
import evgenulianov.task02_rest.service.UnauthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) throws RuntimeException{
        return service.getAuthorities(user, password);
    }

}