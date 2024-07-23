package com.github.IliyaBarbarossa.loginkey.services;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import com.github.IliyaBarbarossa.loginkey.models.Group;
import com.github.IliyaBarbarossa.loginkey.repositories.AccRep;
import com.github.IliyaBarbarossa.loginkey.repositories.GrouppRep;
import com.github.IliyaBarbarossa.loginkey.responses.AccResp;
import com.github.IliyaBarbarossa.loginkey.responses.GrouppResp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GrouppService {
    private GrouppRep grouppRep;
    private AccRep accRep;

    public GrouppService(GrouppRep grouppRep, AccRep accRep) {
        this.grouppRep = grouppRep;
        this.accRep = accRep;
    }

    public Group newGroupp(String name, int permition) {
        Group group = new Group();
        group.setName(name);
        group.setPermition(permition);
        return grouppRep.save(group);

    }

    public Group getGroup(int id) {
        return grouppRep.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Group> getAllGroup() {
        List<Group> groupList = new ArrayList<>();
        grouppRep.findAll().forEach(a -> groupList.add(a));
        return groupList;
    }

    public Group putAccauntInGroup(int accId, int groupId){
        Account account = accRep.findById(accId).orElseThrow(NoSuchElementException::new);
        Group group = grouppRep.findById(groupId).orElseThrow(NoSuchElementException::new);

        if(account.getGroups()==null){
            List<Group> groupList = new ArrayList<>();
            groupList.add(group);
            account.setGroups(groupList);
            accRep.save(account);
            return group;
        }else {
            List<Group> groupList = account.getGroups();
            groupList.add(group);
            account.setGroups(groupList);
            accRep.save(account);
            return group;
        }
    }

}
