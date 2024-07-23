package com.github.IliyaBarbarossa.loginkey.responses;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class GrouppResp {
    int id;
    String name;
    int permition;
    List<AccResp> accounts;
}
