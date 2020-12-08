package com.example.demo.services.adresseService;

import com.example.demo.entity.AdresseEntity;
import com.example.demo.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class AdresseServiceImplement implements AdresseService{
    @Autowired
    AdresseRepository adresseRepository;

    @Transactional
    @Override
    public Iterable<AdresseEntity> getAllAdresse() {
        return this.adresseRepository.findAllAdresse();
    }

    @Transactional
    @Override
    public Optional<AdresseEntity> getAdresseById(int id) {
        return this.adresseRepository.findById(id);
    }

    @Transactional
    @Override
    public void deleteAdresseById(int id) {
        this.adresseRepository.deleteById(id);
    }

    @Transactional
    @Override
    public AdresseEntity addAdresse(AdresseEntity adresseEntity) {
        return this.adresseRepository.save(adresseEntity);
    }

    @Override
    public Iterable<AdresseEntity> getAllAdresseParam(List<String> id_adresse, List<String> libelle, List<String> id_concessionaire) {
        if(id_adresse==null && libelle==null && id_concessionaire==null){
            return this.getAllAdresse();
        }
        return this.adresseRepository.findAllAdresseParam(id_adresse, libelle, id_concessionaire);
    }

}
