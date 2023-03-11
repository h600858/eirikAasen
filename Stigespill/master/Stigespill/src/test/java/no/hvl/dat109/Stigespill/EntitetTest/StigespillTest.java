package no.hvl.dat109.Stigespill.EntitetTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

import no.hvl.dat109.Stigespill.Model.Rute;
import no.hvl.dat109.Stigespill.Model.Spiller;
import no.hvl.dat109.Stigespill.Model.Stigespill;
import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettRepo;
import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettService;


@ExtendWith(MockitoExtension.class)
class StigespillTest {

	private Stigespill stigespill;
	private List<Rute> ruter = new ArrayList<Rute>();
	private Rute r1 = new Rute(2, 30, "Stige");
	private Rute r2 = new Rute(4,20,"Stige");
	private Rute r3 = new Rute(6,2,"Slange");
	
	@InjectMocks
	BrettService service;
	
	@Mock
	BrettRepo repo;
	
	@BeforeEach
	public void Start() {
		stigespill = new Stigespill();
		ruter.add(r1);
		ruter.add(r2);
		ruter.add(r3);
		
	}
	
	@Test
	public void startSpillTest() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(4);
		//Assert
		assertTrue(stigespill.getSpillere().size()==4);
		assertTrue(stigespill.getTerning()!=null);
		assertTrue(stigespill.getBrett()!=null);
	}
	
	@Test
	public void taTurTest() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		stigespill.taTur();
		//Sjekker at første spilleren flytter seg
		assertTrue(stigespill.getSpillere().get(0).getPosisjon()!=0);
		//Sjekker at dersom spilleren triller seks, blir turen ikkje gitt videre
		//og viss han ikkje triller seks blir turen ikkje gitt videre
		if (stigespill.getAntallSeksere()==0) {
			assertTrue(stigespill.getHarTur().equals(stigespill.getSpillere().get(1)));
		} else {
			assertTrue(stigespill.getHarTur().equals(stigespill.getSpillere().get(0)));
		}
		//Sjekker at dersom spilleren lander på en slange, flyttes han til riktig rute og
		//turen blir gitt videre
		stigespill.taTur(2);
		Spiller forrigeTur = stigespill.getSpillere().get(stigespill.getSpillere().indexOf(stigespill.getHarTur())-1);
		assertTrue(forrigeTur.getPosisjon()==32);
		assertTrue(stigespill.getHarTur()!=forrigeTur);
		
		
	}
	
	@Test
	public void forLangTest() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		//Assert
		assertFalse(stigespill.forLang(0));
		assertTrue(stigespill.forLang(101));
	}
	
	@Test
	public void giTurenVidere() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		stigespill.giTurenVidere();
		//Assert
		assertTrue(stigespill.getHarTur().equals(stigespill.getSpillere().get(1)));
		stigespill.giTurenVidere();
		assertTrue(stigespill.getHarTur().equals(stigespill.getSpillere().get(2)));
		stigespill.giTurenVidere();
		assertTrue(stigespill.getHarTur().equals(stigespill.getSpillere().get(0)));
	}
	
	@Test
	public void sjekkOmSlangeEllerStigeEllerVunnet() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		stigespill.getHarTur().setPosisjon(2);
		stigespill.sjekkOmSlangeEllerStigeEllerVunnet(stigespill.getHarTur().getPosisjon());
		assertTrue(stigespill.getHarTur().getPosisjon()==32);
		stigespill.getHarTur().setPosisjon(4);
		stigespill.sjekkOmSlangeEllerStigeEllerVunnet(stigespill.getHarTur().getPosisjon());
		assertTrue(stigespill.getHarTur().getPosisjon()==24);
		stigespill.getHarTur().setPosisjon(6);
		stigespill.sjekkOmSlangeEllerStigeEllerVunnet(stigespill.getHarTur().getPosisjon());
		assertTrue(stigespill.getHarTur().getPosisjon()==4);
		stigespill.getHarTur().setPosisjon(100);
		stigespill.sjekkOmSlangeEllerStigeEllerVunnet(100);
		assertFalse(stigespill.getStartet());

	}
	
	@Test
	public void sjekkOmSekser() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		assertTrue(stigespill.sjekkOmSekser(6));
		assertTrue(stigespill.getAntallSeksere()==1);
		assertTrue(stigespill.sjekkOmSekser(6));
		assertTrue(stigespill.getAntallSeksere()==2);
		assertTrue(stigespill.sjekkOmSekser(6));
		assertTrue(stigespill.getAntallSeksere()==0);
		Spiller forrigespiller = stigespill.getSpillere().get(stigespill.getSpillere().indexOf(stigespill.getHarTur())-1);
		assertTrue(forrigespiller.getFengsel());
	}
	
	@Test
	public void avsluttSpill() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		stigespill.avsluttSpill();
		assertFalse(stigespill.getStartet());
	}
	
	@Test
	public void sjekkFengsel() {
		stigespill.getBrett().setService(service);
		//Arrange
		when(repo.findAll()).thenReturn(ruter);
		//Act
		stigespill.startSpill(3);
		assertFalse(stigespill.sjekkFengsel());
		stigespill.getHarTur().setFengsel(true);
		assertTrue(stigespill.sjekkFengsel());
		assertTrue(stigespill.sjekkFengsel(6));
		assertFalse(stigespill.sjekkFengsel());
	}
	
}
