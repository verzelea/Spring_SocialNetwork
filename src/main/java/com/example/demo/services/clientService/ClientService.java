package com.example.demo.services.clientService;

import com.example.demo.entity.ClientEntity;

import java.util.Optional;

public interface ClientService {

    public Iterable<ClientEntity>getAllClient();

    Optional<ClientEntity> getClientById(int id);

    void deleteClientById(int id);

    ClientEntity addClient(ClientEntity clientEntity);
}
