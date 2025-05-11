package tn.itbs.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.project.model.Employe;
import tn.itbs.project.repository.EmployeRepository;
@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe not found with id: " + id));
    }
    
    @Override
    public Employe updateEmploye(Long id, Employe updatedEmploye) {
        Employe existing = employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe not found with id: " + id));

        existing.setNom(updatedEmploye.getNom());
        existing.setPoste(updatedEmploye.getPoste());
        existing.setMachineAssignee(updatedEmploye.getMachineAssignee());

        return employeRepository.save(existing);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    
}
