package no.hvl.dat109.Stigespill.EntitetTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.Stigespill.Model.Spiller;


public class SpillerTest {

	private Spiller spiller1;
	
	@BeforeEach
	public void start() {
	 spiller1 = new Spiller("TestSpiller");	
	}

	@Test
	public void flyttTest() {
		assertTrue(spiller1.getPosisjon()==0);
		spiller1.flytt(3);
		assertTrue(spiller1.getPosisjon()==3);
		spiller1.flytt(20);
		assertTrue(spiller1.getPosisjon()==23);
		spiller1.flytt(-3);
		assertTrue(spiller1.getPosisjon()==20);
	}
}
