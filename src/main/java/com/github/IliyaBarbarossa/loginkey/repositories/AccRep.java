package com.github.IliyaBarbarossa.loginkey.repositories;

import com.github.IliyaBarbarossa.loginkey.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRep extends CrudRepository<Account,Integer>, PagingAndSortingRepository<Account,Integer> {
     Account findByLogin(String login);

}
