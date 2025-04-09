package tn.itbs.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.project.model.OrdreFabrication;
import tn.itbs.project.repository.OrdreFabricationRepository;

@Service
public class OrdreFabricationServiceImpl implements OrdreFabricationService {

	@Autowired
	private OrdreFabricationRepository ordreFabricationRepository;
	
	@Override 
	public List<OrdreFabrication> getAllOrdres(){
		return ordreFabricationRepository.findAll();
	}
	
	@Override
    public OrdreFabrication createOrdre(OrdreFabrication ordre) {
        return ordreFabricationRepository.save(ordre);
    }
	
	@Override
    public OrdreFabrication getOrdreById(Long id) {
        return ordreFabricationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordre not found with id: " + id));
	}
	
	@Override
    public void deleteOrdre(Long id) {
        ordreFabricationRepository.deleteById(id);
    }
}
