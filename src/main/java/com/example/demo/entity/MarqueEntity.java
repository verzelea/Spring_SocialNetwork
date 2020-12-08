package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "marque")
public class MarqueEntity {

    @Id
    private int id_marque;
    private String nom;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_marque", referencedColumnName = "id_marque", updatable = false, insertable = false)
    private Set<VoitureEntity> listVoiture = new HashSet<VoitureEntity>();

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(mappedBy = "marques")
    private Set<ConcessionaireEntity> concessionnaires = new HashSet<ConcessionaireEntity>();

    public MarqueEntity(){}

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
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

    public Set<ConcessionaireEntity> getConcessionnaires() {
        return concessionnaires;
    }

    public void setConcessionnaires(Set<ConcessionaireEntity> concessionnaires) {
        this.concessionnaires = concessionnaires;
    }
}
