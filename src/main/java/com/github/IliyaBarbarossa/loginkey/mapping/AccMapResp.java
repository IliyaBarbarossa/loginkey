package com.github.IliyaBarbarossa.loginkey.mapping;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import com.github.IliyaBarbarossa.loginkey.models.Group;
import com.github.IliyaBarbarossa.loginkey.responses.AccResp;
import com.github.IliyaBarbarossa.loginkey.responses.GrouppResp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccMapResp {
    public AccResp mapToResponse(Account account){
        if(account==null){
           return null;
        }

        AccResp accResp = new AccResp();
        accResp.setId(account.getId());
        accResp.setLogin(account.getLogin());
        accResp.setPassword(account.getPassword());
        accResp.setGroups(listmapGroupResp(account.getGroups()));
        accResp.setPermition(account.getPermition());
        return accResp;
    }

    private List<GrouppResp> listmapGroupResp(List<Group> source) {
        if (source == null) {
            return null;
        }
        return source.stream()
                .map(this::mapGroup)
                .toList();
    }

    private GrouppResp mapGroup(Group group) {
        if (group == null) {
            return null;
        }
        GrouppResp grouppResp = new GrouppResp();
        grouppResp.setId(group.getId());
        grouppResp.setName(group.getName());
        grouppResp.setPermition(group.getPermition());
        return grouppResp;
    }

}
