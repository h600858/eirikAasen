package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.lph.dat108.Models.Deltager;
import no.hvl.lph.dat108.Models.deltagerRepo;
import no.hvl.lph.dat108.Services.deltagerService;

@ExtendWith(MockitoExtension.class)
public class DeltagerServiceTest {

	@InjectMocks
	deltagerService ds;
	
	@Mock
	deltagerRepo dr;
	
	@Test
	void finnDeltagerMedMobil() {
		int mobil = 90214494;
		Optional<Deltager> resultat = ds.finndeldtagerMedMobil(mobil);
		
		assertTrue(resultat != null);
	}
	
	@Test
	void getDeltagere() {
		when( dr.findAll()).thenReturn(List.of(
				new Deltager("Eirik", "Aasen", "90214494", "nokkeE", "nokkeiIgjen", "12345", 'M'),
				new Deltager("Johanne", "Johannesen", "9012296", "noe", "noe", "12345", 'M'),
				new Deltager("Per", "Aasen", "90214494", "noe", "noeigjen", "passord", 'M'),
				new Deltager("Eirik", "Pedersen", "90214494", "nokkeE", "nokkeiIgjen", "12345", 'M')));
		
		List<Deltager> resultat = ds.getDeltagere();
		assertTrue(resultat.get(0).getEtternavn().equals("Aasen"));
		assertTrue(resultat.get(1).getEtternavn().equals("Pedersen"));
		assertEquals(4, resultat.size());
	}
	
}
