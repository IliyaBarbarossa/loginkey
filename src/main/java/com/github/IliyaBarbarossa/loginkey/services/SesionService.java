package com.github.IliyaBarbarossa.loginkey.services;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class SesionService {

    private Map<String, AccessToken> tokenMap = new HashMap<>();
    private AccService accService;

    public SesionService(AccService accService) {
        this.accService = accService;
    }

    public boolean sistemIn(Account account, String password) {
        return account.getPassword().equals(password);
    }

    public String enter(String login, String password) {
        Account account = accService.findByLogin(login);
        if (sistemIn(account, password)) {
            UUID uuid = UUID.randomUUID();
            AccessToken accessToken = new AccessToken(uuid.toString(), account.getId(), new Date());
            tokenMap.put(accessToken.getToken(), accessToken);
            return accessToken.getToken();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasToken(String token) {
        return tokenMap.containsKey(token);
    }

    public boolean canLi(String token, int permition) {
        AccessToken accessToken = tokenMap.get(token);
        if(accessToken==null){
            throw new RuntimeException("noToken");
        }
        Account account = accService.getAcc(accessToken.getAccountId());
        return accService.canLiDo(account, permition);
    }

}
