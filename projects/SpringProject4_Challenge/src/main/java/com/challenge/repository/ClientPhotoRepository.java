package com.challenge.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.model.ClientPhotoDAO;

public interface ClientPhotoRepository extends MongoRepository<ClientPhotoDAO, String> {

//	@Query("{ 'idType': ?0, 'idValue': ?1}")
	List<ClientPhotoDAO> findByIdTypeAndIdValue(String idType, String idValue);

}
