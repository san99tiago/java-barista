package com.challenge.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.model.ClientPhotoORM;

public interface ClientPhotoRepository extends MongoRepository<ClientPhotoORM, String> {

//	@Query("{ 'idType': ?0, 'idValue': ?1}")
	List<ClientPhotoORM> findByIdTypeAndIdValue(String idType, String idValue);

}
