package no.hvl.dat109.Stigespill.ServiceOgRepoer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.Stigespill.Model.Rute;


@Service
public class BrettService {

	@Autowired BrettRepo repo;
	
	public List<Rute> getRuter(){
		return repo.findAll();
	}
	
}
