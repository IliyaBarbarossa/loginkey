package com.github.IliyaBarbarossa.loginkey.services;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import com.github.IliyaBarbarossa.loginkey.models.Group;
import com.github.IliyaBarbarossa.loginkey.repositories.AccRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;

@Service
public class AccService {
    private AccRep accRep;

    public AccService(AccRep accRep) {
        this.accRep = accRep;
    }

    public Account newAccaunt(String login, String password) {
        Account account = new Account();
        account.setLogin(login);
        account.setPassword(password);
        return accRep.save(account);
    }

    public void setPermition(int accauntid, int permition) {
        Account acc = accRep.findById(accauntid).orElseThrow(NoSuchElementException::new);
        acc.setPermition(permition);
        accRep.save(acc);
    }

    public Account getAcc(int id) {
        return accRep.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Account> getAllAcc() {
        List<Account> accountList = new ArrayList<>();
        accRep.findAll().forEach(a -> accountList.add(a));
        return accountList;
    }

    public boolean canLiDo(Account account, int permition) {
        int p = account.getPermition();
        List<Group> groups = account.getGroups();
        if (groups == null) {
            return p > 0 & p <= permition;
        } else {
            int min = groups.stream()
                    .mapToInt(a -> a.getPermition())
                    .min().orElse(Integer.MAX_VALUE);
            int min1 = Math.min(p, min);
            return min1 > 0 && min1 <= permition;
        }

    }

    public Account findByLogin(String login) {
        return accRep.findByLogin(login);
    }


}
