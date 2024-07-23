package com.github.IliyaBarbarossa.loginkey.models;

import com.github.IliyaBarbarossa.loginkey.responses.AccResp;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "groupp") public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int permition;
    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    List<Account> accounts;
}
