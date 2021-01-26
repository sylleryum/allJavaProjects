package com.springbootwebdemo.DAO;

import com.springbootwebdemo.Entity.Pojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PojoRepo extends JpaRepository<Pojo, Integer> {

}
