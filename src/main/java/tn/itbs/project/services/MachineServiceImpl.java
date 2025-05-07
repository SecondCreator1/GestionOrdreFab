package tn.itbs.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.project.model.Machine;
import tn.itbs.project.repository.MachineRepository;

@Service
public class MachineServiceImpl implements MachineService {
	

    @Autowired
    private MachineRepository machineRepository;

    @Override
    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    @Override
    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine not found with id: " + id));
    }

    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

}
