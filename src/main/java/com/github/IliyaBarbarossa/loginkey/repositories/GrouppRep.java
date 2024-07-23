package com.github.IliyaBarbarossa.loginkey.repositories;

import com.github.IliyaBarbarossa.loginkey.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrouppRep extends CrudRepository<Group,Integer> {
}
