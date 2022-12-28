package com.crudperson.web.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudperson.web.entities.personEntity;

@Repository
public interface iPersonRepository extends JpaRepository<personEntity, Long> {

}
