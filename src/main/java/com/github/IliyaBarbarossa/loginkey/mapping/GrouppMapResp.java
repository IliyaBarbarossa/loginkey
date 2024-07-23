package com.github.IliyaBarbarossa.loginkey.mapping;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import com.github.IliyaBarbarossa.loginkey.models.Group;
import com.github.IliyaBarbarossa.loginkey.responses.AccResp;
import com.github.IliyaBarbarossa.loginkey.responses.GrouppResp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrouppMapResp {
    public GrouppResp mapToResponse(Group group){
        if(group == null){
            return null;
        }
        GrouppResp grouppResp = new GrouppResp();
        grouppResp.setId(group.getId());
        grouppResp.setName(group.getName());
        grouppResp.setPermition(group.getPermition());
        grouppResp.setAccounts(mapAccList(group.getAccounts()));
        return grouppResp;
    }

    private List<AccResp> mapAccList(List<Account> source) {
        if (source == null) {
            return null;
        }
        return source.stream()
                .map(this::mapAccount)
                .toList();
    }

    private AccResp mapAccount(Account account) {
        if (account == null) {
            return null;
        }
        AccResp accResp = new AccResp();
        accResp.setId(account.getId());
        accResp.setLogin(account.getLogin());
        accResp.setPermition(account.getPermition());
        return accResp;
    }
}
