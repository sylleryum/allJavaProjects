package com.mongodb.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName (String lastName);

}
