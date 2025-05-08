package tn.itbs.project.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity

public class Machine {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nom;

    private String etat; // Ex: "Disponible", "En maintenance"

    private LocalDate derniereMaintenance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public LocalDate getDerniereMaintenance() {
		return derniereMaintenance;
	}

	public void setDerniereMaintenance(LocalDate derniereMaintenance) {
		this.derniereMaintenance = derniereMaintenance;
	}
    
    

}
