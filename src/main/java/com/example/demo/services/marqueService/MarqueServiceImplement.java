package com.example.demo.services.marqueService;

import com.example.demo.entity.MarqueEntity;
import com.example.demo.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class MarqueServiceImplement implements MarqueService{

    @Autowired
    MarqueRepository marqueRepository;

    @Override
    public Iterable<MarqueEntity> getAllMarque() {
        return this.marqueRepository.findAllMarque();
    }

    @Override
    public Optional<MarqueEntity> getMarqueById(int id) {
        return this.marqueRepository.findById(id);
    }

    @Override
    public MarqueEntity addMarque(MarqueEntity marqueEntity) {
        return this.marqueRepository.save(marqueEntity);
    }

    @Transactional
    @Override
    public void deleteMarqueById(int id) {
        this.marqueRepository.deleteById(id);
    }
}
