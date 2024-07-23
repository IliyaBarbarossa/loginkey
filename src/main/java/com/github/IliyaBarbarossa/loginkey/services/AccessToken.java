package com.github.IliyaBarbarossa.loginkey.services;

import lombok.Data;

import java.util.Date;

@Data
public class AccessToken {
    private final String token;
    private final int accountId;
    private final Date tokenDate;
}
