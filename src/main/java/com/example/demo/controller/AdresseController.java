package com.example.demo.controller;

import com.example.demo.entity.AdresseEntity;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.services.adresseService.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class AdresseController {

    @Autowired
    AdresseService adresseService;

    /*
    Another method with @RequestParam (replace get All method) -> I didn't create this features for the other controllers
    in order to keep them very simple
     */
    @GetMapping("/adresse")
    public Iterable<AdresseEntity> getAllAdresseParam(@RequestParam(value = "id_adresse", required = false) List<String> id_adresse,
                                                   @RequestParam(value = "libelle", required = false)List<String> libelle,
                                                   @RequestParam(value = "id_concessionaire", required = false)List<String> id_concessionaire){
        return this.adresseService.getAllAdresseParam(id_adresse, libelle, id_concessionaire);
    }

    @GetMapping("/adresse/{id}")
    public Optional<AdresseEntity>getAdresseById(@PathVariable("id") int id){
    return this.adresseService.getAdresseById(id);
    }

    @PostMapping("/adresse")
    public AdresseEntity addAdresseById(@RequestBody AdresseEntity adresseEntity) {
        return this.adresseService.addAdresse(adresseEntity);
    }

    @DeleteMapping("/adresse/{id}")
    public Map<String, Boolean> deleteAdresseById(@PathVariable("id") int id) throws RessourceNotFoundException {
        if(this.adresseService.getAdresseById(id).get().equals(null))
            throw new RessourceNotFoundException("Not found any address to this Id ::" + id);
        adresseService.deleteAdresseById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/adresse/{id}")
    public AdresseEntity updateAdresseById(@PathVariable("id") int id, @RequestBody AdresseEntity adresseEntity) throws RessourceNotFoundException {
        AdresseEntity adresse = adresseService.getAdresseById(id).get();
        if(adresse.equals(null))
            throw new RessourceNotFoundException("Not found any address to this Id ::" + id);

        adresse.setId_concessionaire(adresseEntity.getId_concessionaire());
        adresse.setLibelle(adresseEntity.getLibelle());
        adresseService.addAdresse(adresse);
        return adresse;
    }
}
