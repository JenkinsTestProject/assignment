package com.uxpsystems.assignment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserRepository
 */
public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findById(long id);

    UserDocument save(UserDocument entity);

    Long deleteById(long id);
}
