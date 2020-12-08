package com.example.demo.services.concessionaireService;

import com.example.demo.entity.ConcessionaireEntity;
import com.example.demo.repository.ConcessionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class ConcessionaireServiceImplement implements ConcessionaireService {
    @Autowired
    ConcessionaireRepository concessionaireRepository;

    @Override
    public Iterable<ConcessionaireEntity> getAllConcessionaire() {
        return this.concessionaireRepository.findAll();
    }

    @Override
    public Optional<ConcessionaireEntity> getConcessionaireById(int co_id) {
        return this.concessionaireRepository.findById(co_id);
    }

    @Override
    public ConcessionaireEntity addConcessionaire(ConcessionaireEntity concessionaireEntity) {
        return this.concessionaireRepository.save(concessionaireEntity);
    }

    @Transactional
    @Override
    public void deleteConcessionaireById(int id) {
        this.concessionaireRepository.deleteById(id);
    }
}
