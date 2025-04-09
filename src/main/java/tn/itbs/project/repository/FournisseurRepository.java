package tn.itbs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.itbs.project.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository <Fournisseur, Long > {

}
