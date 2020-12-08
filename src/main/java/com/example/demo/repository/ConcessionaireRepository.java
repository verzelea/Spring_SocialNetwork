package com.example.demo.repository;

import com.example.demo.entity.ConcessionaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="concessionaire")
public interface ConcessionaireRepository extends JpaRepository<ConcessionaireEntity, Integer> {
}
