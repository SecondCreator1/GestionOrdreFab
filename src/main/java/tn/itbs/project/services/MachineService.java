package tn.itbs.project.services;

import java.util.List;

import tn.itbs.project.model.Machine;

public interface MachineService {

	 List<Machine> getAllMachines();
	    Machine createMachine(Machine machine);
	    Machine getMachineById(Long id);
	    void deleteMachine(Long id);
		Machine updateMachine(Long id, Machine updatedMachine);
}
