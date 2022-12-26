package com.example.fournisseurs.dao;

import com.example.fournisseurs.models.Fournisseur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Fr_dao {

    @PersistenceContext(unitName = "rest_api")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Fournisseur.findAll", Fournisseur.class).getResultList();
    }

    public Fournisseur findById(Long id) {
        return em.find(Fournisseur.class, id);
    }
    public Fournisseur findByVille(String ville) {return em.find(Fournisseur.class, ville); }

    public void create(Fournisseur fournisseur) {
        em.persist(fournisseur);
    }

    public void delete(Fournisseur fournisseur) {
        if (!em.contains(fournisseur)) {
            fournisseur = em.merge(fournisseur);
        }

        em.remove(fournisseur);
    }


}