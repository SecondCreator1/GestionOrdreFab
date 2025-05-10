package tn.itbs.project.services;

import java.util.List;

import tn.itbs.project.model.OrdreFabrication;

public interface OrdreFabricationService {
	List<OrdreFabrication> getAllOrdres();
    OrdreFabrication createOrdre(OrdreFabrication ordre);
    OrdreFabrication getOrdreById(Long id);
    void deleteOrdre(Long id);
    OrdreFabrication updateOrdre(Long id, OrdreFabrication updatedOrdre);
}
