package com.challenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.model.ClientPhotoORM;

public interface ClientPhotoRepository extends MongoRepository<ClientPhotoORM, Integer> {

}
