package tn.itbs.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.itbs.project.model.Fournisseur;
import tn.itbs.project.repository.FournisseurRepository;

public class FournisseurServiceImpl implements FournisseurService {


    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur not found with id: " + id));
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
