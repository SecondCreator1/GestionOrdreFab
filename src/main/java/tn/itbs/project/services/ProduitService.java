package tn.itbs.project.services;

import java.util.List;

import tn.itbs.project.model.Produit;

public interface ProduitService {
	List<Produit> getAllProduits();
    Produit createProduit(Produit produit);
    Produit getProduitById(Long id);
    void deleteProduit(Long id);
    Produit updateProduit(Long id, Produit updatedProduit);

}
