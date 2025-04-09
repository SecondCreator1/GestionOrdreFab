package tn.itbs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.itbs.project.model.Employe;

public interface EmployeRepository extends JpaRepository <Employe, Long> {

}
