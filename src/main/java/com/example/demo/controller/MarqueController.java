package com.example.demo.controller;

import com.example.demo.entity.AdresseEntity;
import com.example.demo.entity.MarqueEntity;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.services.marqueService.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class MarqueController {

    @Autowired
    MarqueService marqueService;

    @GetMapping("/marque")
    public Iterable<MarqueEntity>getAllMarque(){
        return marqueService.getAllMarque();
    }

    @GetMapping("/marque/{id}")
    public Optional<MarqueEntity>getMarqueById(@PathVariable("id") int id){
        return this.marqueService.getMarqueById(id);
    }

    @PostMapping("/marque")
    public MarqueEntity addMarque(@RequestBody MarqueEntity marqueEntity){
        return this.marqueService.addMarque(marqueEntity);
    }

    @DeleteMapping("/marque/{id}")
    public Map<String, Boolean> deleteMarqueById(@PathVariable("id") int id) throws RessourceNotFoundException {
        if(this.marqueService.getMarqueById(id).get().equals(null))
            throw new RessourceNotFoundException("Not found any marque to this Id ::" + id);
        marqueService.deleteMarqueById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/marque/{id}")
    public MarqueEntity updateMarqueById(@PathVariable("id") int id, @RequestBody MarqueEntity marqueEntity) throws RessourceNotFoundException {
        MarqueEntity marque = marqueService.getMarqueById(id).get();
        if(marque.equals(null))
            throw new RessourceNotFoundException("Not found any marque to this Id ::" + id);

        marque.setConcessionnaires(marqueEntity.getConcessionnaires());
        marque.setListVoiture(marqueEntity.getListVoiture());
        marque.setNom(marqueEntity.getNom());
        marqueService.addMarque(marque);
        return marque;
    }
}
