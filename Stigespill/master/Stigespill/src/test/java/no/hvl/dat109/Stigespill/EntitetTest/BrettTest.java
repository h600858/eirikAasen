package no.hvl.dat109.Stigespill.EntitetTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.dat109.Stigespill.Model.Brett;
import no.hvl.dat109.Stigespill.Model.Rute;
import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettRepo;
import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettService;

@ExtendWith(MockitoExtension.class)
 class BrettTest {

	private Rute r1 = new Rute(2, 30, "Slange");
	private Rute r2 = new Rute(4,20,"Stige");
	private Rute r3 = new Rute(6,9,"Slange");
	private List<Rute> ruter = new ArrayList<Rute>();
	private Brett brett;
	
	@BeforeEach
	public void makeReady() {
		brett = new Brett();
		ruter.add(r1);
		ruter.add(r2);
		ruter.add(r3);
	}
	
	@InjectMocks
	BrettService service;
	
	@Mock
	BrettRepo repo;
	
	@Test
	public void test() {
		brett.setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		brett.initialiser();
		//Assert
		assertTrue(brett.getRuter()[2].getLengde()==30);
		assertTrue(brett.getRuter()[4].getLengde()==20);
		assertTrue(brett.getRuter()[6].getLengde()==9);
	}
}

	
