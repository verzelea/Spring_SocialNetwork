package com.example.demo.controller;

import com.example.demo.entity.AdresseEntity;
import com.example.demo.entity.VoitureEntity;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.services.voitureService.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class VoitureController {

    @Autowired
    VoitureService voitureService;

    @GetMapping("/voiture")
    public Iterable<VoitureEntity>getAllVoiture(){ return this.voitureService.getAllVoiture(); }

    @GetMapping("/voiture/{id}")
    public Optional<VoitureEntity>getVoitureById(@PathVariable("id")int id){
        return this.voitureService.getVoitureById(id);
    }

    @PostMapping("/voiture")
    public VoitureEntity addVoiture(@RequestBody VoitureEntity voitureEntity){
        return this.voitureService.addVoiture(voitureEntity);
    }

    @DeleteMapping("/voiture/{id}")
    public Map<String, Boolean> deleteVoitureById(@PathVariable("id") int id) throws RessourceNotFoundException {
        if(this.voitureService.getVoitureById(id).get().equals(null))
            throw new RessourceNotFoundException("Not found any voiture to this Id ::" + id);
        voitureService.deleteVoitureById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/voiture/{id}")
    public VoitureEntity updateVoitureById(@PathVariable("id") int id, @RequestBody VoitureEntity voitureEntity) throws RessourceNotFoundException {
        VoitureEntity voiture = voitureService.getVoitureById(id).get();
        if(voiture.equals(null))
            throw new RessourceNotFoundException("Not found any voiture to this Id ::" + id);

        voiture.setId_client(voitureEntity.getId_client());
        voiture.setId_marque(voitureEntity.getId_marque());
        voiture.setModele(voitureEntity.getModele());
        voitureService.addVoiture(voiture);
        return voiture;
    }
}
