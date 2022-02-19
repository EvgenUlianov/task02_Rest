package evgenulianov.task02_rest.controllers;

import evgenulianov.task02_rest.config.ConvertToUser;
import evgenulianov.task02_rest.model.MyUser;
import evgenulianov.task02_rest.service.Authorities;
import evgenulianov.task02_rest.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @ConvertToUser MyUser user) throws RuntimeException{
        return service.getAuthorities(user);
    }

}