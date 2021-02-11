package com.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.challenge.model.ClientORM;

public interface ClientRepository extends CrudRepository<ClientORM, Integer> {

	List<ClientORM> findByIdTypeAndIdValue(String idType, String idValue);
	List<ClientORM> findByAgeGreaterThan(int age);
}
