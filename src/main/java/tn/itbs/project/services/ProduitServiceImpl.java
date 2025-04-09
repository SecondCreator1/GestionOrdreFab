package tn.itbs.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.itbs.project.model.Produit;
import tn.itbs.project.repository.ProduitRepository;

public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit not found with id: " + id));
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
