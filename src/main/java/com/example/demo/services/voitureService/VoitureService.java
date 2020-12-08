package com.example.demo.services.voitureService;

import com.example.demo.entity.VoitureEntity;

import java.util.Optional;

public interface VoitureService {
    public Iterable<VoitureEntity>getAllVoiture();

    Optional<VoitureEntity> getVoitureById(int id);

    VoitureEntity addVoiture(VoitureEntity voitureEntity);

    void deleteVoitureById(int id);
}
