package com.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.challenge.model.ClientORM;

public interface ClientRepository extends CrudRepository<ClientORM, Integer>{

}
