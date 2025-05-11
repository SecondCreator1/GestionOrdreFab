package tn.itbs.project.services;

import java.util.List;

import tn.itbs.project.model.Employe;

public interface EmployeService {
	List<Employe> getAllEmployes();
    Employe createEmploye(Employe employe);
    Employe getEmployeById(Long id);
    Employe updateEmploye(Long id, Employe updatedEmploye);
    void deleteEmploye(Long id);
}
