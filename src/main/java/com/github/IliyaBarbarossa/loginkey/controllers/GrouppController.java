package com.github.IliyaBarbarossa.loginkey.controllers;

import com.github.IliyaBarbarossa.loginkey.mapping.GrouppMapResp;
import com.github.IliyaBarbarossa.loginkey.responses.AccResp;
import com.github.IliyaBarbarossa.loginkey.responses.GrouppResp;
import com.github.IliyaBarbarossa.loginkey.services.AccService;
import com.github.IliyaBarbarossa.loginkey.services.GrouppService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GrouppController {
    private GrouppService grouppService;
    private GrouppMapResp grouppMapResp;

    public GrouppController(GrouppService grouppService, GrouppMapResp grouppMapResp) {
        this.grouppService = grouppService;
        this.grouppMapResp = grouppMapResp;
    }

    @PutMapping
    public GrouppResp newGroup(String name, int permition){
        return grouppMapResp.mapToResponse(grouppService.newGroupp(name, permition));
    }

    @PatchMapping
    public GrouppResp addAccinGroup(int accId, int groupId){
       return grouppMapResp.mapToResponse(grouppService.putAccauntInGroup(accId,groupId));
    }
}
