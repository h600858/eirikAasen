package no.hvl.dat109.Stigespill.EntitetTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import no.hvl.dat109.Stigespill.Model.Terning;

@SpringBootTest
public class TerningTest {
	
	private Terning terning;
	
	@BeforeEach
	public void Start() {
		terning = new Terning();
	}
	
	@Test
	public void trillTerningTest() {
		int trillet = 0;
		for (int i = 0; i<99; i++) {
			trillet = terning.trillTerning();
			assertTrue(trillet<=6&&trillet>=1);
		}
	}
}
