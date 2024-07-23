package com.github.IliyaBarbarossa.loginkey.controllers;

import com.github.IliyaBarbarossa.loginkey.services.AccService;
import com.github.IliyaBarbarossa.loginkey.services.SesionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    private SesionService sesionService;

    public SessionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }
    @GetMapping
    public String login(String login,String password){
        return sesionService.enter(login, password);
    }
    @GetMapping("/token")
    public boolean logInOrOut(String token, int permition){
        return sesionService.canLi(token, permition);
    }

}
