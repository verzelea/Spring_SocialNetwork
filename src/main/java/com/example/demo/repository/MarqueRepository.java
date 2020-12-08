package com.example.demo.repository;

import com.example.demo.entity.MarqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="marque")
public interface MarqueRepository extends JpaRepository <MarqueEntity, Integer>{

    @Query(value = "select * from marque", nativeQuery = true)
    List<MarqueEntity>findAllMarque();
}
