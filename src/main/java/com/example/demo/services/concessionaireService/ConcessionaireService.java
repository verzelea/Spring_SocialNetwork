package com.example.demo.services.concessionaireService;

import com.example.demo.entity.ConcessionaireEntity;

import java.util.Optional;

public interface ConcessionaireService {

    public Iterable<ConcessionaireEntity>getAllConcessionaire();

    Optional<ConcessionaireEntity> getConcessionaireById(int co_id);

    ConcessionaireEntity addConcessionaire(ConcessionaireEntity concessionaireEntity);

    void deleteConcessionaireById(int id);
}
