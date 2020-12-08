package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "client")
public class ClientEntity{
    @Id
    private int id_client;
    private String nom;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", updatable = false, insertable = false)
    private Set<VoitureEntity> listVoiture = new HashSet<VoitureEntity>();

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<VoitureEntity> getListVoiture() {
        return listVoiture;
    }

    public void setListVoiture(Set<VoitureEntity> listVoiture) {
        this.listVoiture = listVoiture;
    }
}

