package com.github.IliyaBarbarossa.loginkey.responses;

import com.github.IliyaBarbarossa.loginkey.models.Group;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;


@Data
public class AccResp {
        int id;
        String login;
        String password;
        List<GrouppResp> groups;
        int permition;
}
