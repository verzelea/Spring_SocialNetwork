package com.example.demo.services.adresseService;

import com.example.demo.entity.AdresseEntity;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Optional;

public interface AdresseService {

    public Iterable<AdresseEntity>getAllAdresse();

    Optional<AdresseEntity> getAdresseById(int id);

    void deleteAdresseById(int id);

    AdresseEntity addAdresse(AdresseEntity adresseEntity);

    Iterable<AdresseEntity> getAllAdresseParam(List<String> id_adresse, List<String> libelle, List<String> id_concessionaire);
}
