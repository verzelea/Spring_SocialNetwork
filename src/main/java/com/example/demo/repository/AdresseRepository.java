package com.example.demo.repository;

import com.example.demo.entity.AdresseEntity;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="adresse")
public interface AdresseRepository extends JpaRepository<AdresseEntity, Integer> {

    @Query(value = "select * from adresse", nativeQuery = true)
    Iterable<AdresseEntity> findAllAdresse();

    @Query(value = "select * from adresse a where " +
            "(coalesce(:id_adresse, null)is null OR a.id_adresse IN (:id_adresse))" +
            "AND (coalesce(:libelle, null) is null OR a.libelle IN (:libelle))" +
            "AND (coalesce(:id_concessionaire, null) is null OR a.id_concessionaire IN (:id_concessionaire))", nativeQuery = true)
    Iterable<AdresseEntity> findAllAdresseParam(@Param("id_adresse") List<String> id_adresse,
                                                @Param("libelle") List<String> libelle, @Param("id_concessionaire") List<String> id_concessionaire);
}
