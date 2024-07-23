package com.github.IliyaBarbarossa.loginkey.controllers;

import com.github.IliyaBarbarossa.loginkey.mapping.AccMapResp;
import com.github.IliyaBarbarossa.loginkey.models.Account;
import com.github.IliyaBarbarossa.loginkey.responses.AccResp;
import com.github.IliyaBarbarossa.loginkey.services.AccService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccController {
    private AccService accService;
    private AccMapResp accMapResp;

    public AccController(AccService accService, AccMapResp accMapResp) {
        this.accService = accService;
        this.accMapResp = accMapResp;
    }

    @PutMapping
    public AccResp newAcc(String login, String password){
        return accMapResp.mapToResponse(accService.newAccaunt(login, password));
    }
    @PatchMapping("/p")
    public void setPermition(int accauntid,int permition){
       accService.setPermition(accauntid,permition);
    }
}
