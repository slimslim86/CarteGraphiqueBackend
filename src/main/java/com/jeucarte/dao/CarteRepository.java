package com.jeucarte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
import com.jeucarte.entity.Carte;


@RepositoryRestResource
public interface CarteRepository extends JpaRepository<Carte, Long> {

}
