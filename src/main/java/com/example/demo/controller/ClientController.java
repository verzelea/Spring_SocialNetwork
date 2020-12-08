package com.example.demo.controller;

import com.example.demo.entity.AdresseEntity;
import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.VoitureEntity;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.services.clientService.ClientService;
import com.example.demo.services.voitureService.VoitureService;
import com.example.demo.services.voitureService.VoitureServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    public Iterable<ClientEntity>getAllCLient(){ return  this.clientService.getAllClient(); }

    @GetMapping("/client/{id}")
    public Optional<ClientEntity>getClientById(@PathVariable("id") int id){
        return this.clientService.getClientById(id);
    }

    @PostMapping("/client")
    public ClientEntity addClient(@RequestBody ClientEntity clientEntity){
        return this.clientService.addClient(clientEntity);
    }

    @DeleteMapping("/client/{id}")
    public Map<String, Boolean> deleteClientById(@PathVariable("id") int id) throws RessourceNotFoundException {
        if(this.clientService.getClientById(id).get().equals(null))
            throw new RessourceNotFoundException("Not found any client to this Id ::" + id);
        clientService.deleteClientById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/client/{id}")
    public ClientEntity updateClientById(@PathVariable("id") int id, @RequestBody ClientEntity clientEntity) throws RessourceNotFoundException {
        ClientEntity client= clientService.getClientById(id).get();
        if(client.equals(null))
            throw new RessourceNotFoundException("Not found any client to this Id ::" + id);

        client.setListVoiture(clientEntity.getListVoiture());
        client.setNom(clientEntity.getNom());
        clientService.addClient(client);
        return client;
    }
}
