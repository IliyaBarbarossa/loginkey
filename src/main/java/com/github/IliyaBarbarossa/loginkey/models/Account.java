package com.github.IliyaBarbarossa.loginkey.models;

import com.github.IliyaBarbarossa.loginkey.responses.GrouppResp;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "accaunt")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String login;
    String password;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "accgr",
            joinColumns = {@JoinColumn(name = "accaunt_id")},
            inverseJoinColumns = {@JoinColumn(name = "groupp_id")}
    )
    List<Group> groups;
    int permition;
}
