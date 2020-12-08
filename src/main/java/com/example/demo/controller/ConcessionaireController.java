package com.example.demo.controller;

import com.example.demo.entity.AdresseEntity;
import com.example.demo.entity.ConcessionaireEntity;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.services.concessionaireService.ConcessionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ConcessionaireController {

    @Autowired
    ConcessionaireService concessionaireService;

    @GetMapping("/concessionaire")
    public Iterable<ConcessionaireEntity>getAllConcessionaire(){ return this.concessionaireService.getAllConcessionaire(); }

    @GetMapping("/concessionaire/{co_id}")
    public Optional<ConcessionaireEntity> getConcessionaireById(@PathVariable("co_id")int co_id){
        return this.concessionaireService.getConcessionaireById(co_id);
    }

    @PostMapping("/concessionaire")
    public ConcessionaireEntity addConcessionaire(@RequestBody ConcessionaireEntity concessionaireEntity){
        return this.concessionaireService.addConcessionaire(concessionaireEntity);
    }

    @DeleteMapping("/concessionaire/{id}")
    public Map<String, Boolean> deleteConcessionaireById(@PathVariable("id") int id) throws RessourceNotFoundException {
        if(this.concessionaireService.getConcessionaireById(id).get().equals(null))
            throw new RessourceNotFoundException("Not found any concesionnaire to this Id ::" + id);
        concessionaireService.deleteConcessionaireById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/concessionaire/{id}")
    public ConcessionaireEntity updateConcessionaireById(@PathVariable("id") int id, @RequestBody ConcessionaireEntity concessionaireEntity) throws RessourceNotFoundException {
        ConcessionaireEntity concessionaire = concessionaireService.getConcessionaireById(id).get();
        if(concessionaire.equals(null))
            throw new RessourceNotFoundException("Not found any concessionaire to this Id ::" + id);

        concessionaire.setListAdresses(concessionaireEntity.getListAdresses());
        concessionaire.setListMarque(concessionaireEntity.getListMarque());
        concessionaire.setNom(concessionaireEntity.getNom());
        concessionaireService.addConcessionaire(concessionaire);
        return concessionaire;
    }
}
