package tn.itbs.project.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String poste;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machineAssignee;

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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Machine getMachineAssignee() {
		return machineAssignee;
	}

	public void setMachineAssignee(Machine machineAssignee) {
		this.machineAssignee = machineAssignee;
	}
    
    
}
