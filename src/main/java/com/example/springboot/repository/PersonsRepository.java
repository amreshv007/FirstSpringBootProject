package com.example.springboot.repository;

import com.example.springboot.model.Persons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends CrudRepository<Persons, Integer> {

    Persons findById(int id);
}
