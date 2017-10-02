package com.francesco.ChiamataRest.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface StudenteRepository extends CrudRepository<StudenteEntity, Long> {

  //public  String addNewStudente ( String matricola,  String nome,  String cognome,  String data);


}
