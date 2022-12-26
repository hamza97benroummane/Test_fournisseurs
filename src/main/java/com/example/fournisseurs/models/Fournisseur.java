package com.example.fournisseurs.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Fournisseur")
@NamedQueries({
        @NamedQuery(name = "Fournisseur.findAll", query = "SELECT F FROM Fournisseur F")
})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long code;
    private String designation;
    private String ville;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long id) {
        this.id = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String description) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", code=" + code + ", designation=" + designation +" , ville=" + ville + '}';
    }

}