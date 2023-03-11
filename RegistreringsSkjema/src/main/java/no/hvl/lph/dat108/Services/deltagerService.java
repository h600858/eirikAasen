package no.hvl.lph.dat108.Services;



import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.lph.dat108.Models.Deltager;

import no.hvl.lph.dat108.Models.deltagerRepo;

@Service
public class deltagerService {

	@Autowired private deltagerRepo DeltagerRepo;
	
	public List<Deltager> getDeltagere(){
		return DeltagerRepo.findAll().stream().sorted(Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn)).toList();
	}
	public Optional<Deltager> finndeldtagerMedMobil(int mobil) {
		return DeltagerRepo.findById(mobil);
	}
}
