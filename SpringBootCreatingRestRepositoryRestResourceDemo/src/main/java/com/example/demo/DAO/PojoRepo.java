package com.example.demo.DAO;

import com.example.demo.Entity.Pojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pojos", path = "pojos")
public interface PojoRepo extends JpaRepository<Pojo, Integer> {

}
