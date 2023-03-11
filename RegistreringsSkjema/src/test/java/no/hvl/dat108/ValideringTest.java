package no.hvl.dat108;

import javax.validation.Validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import no.hvl.lph.dat108.Util.InputValidator;
import no.hvl.lph.dat108.Util.PassordUtil;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.*;

public class ValideringTest {

	private static InputValidator validator;
	private static PassordUtil passordUtil;
	
	@Test
	public void gyldigNnavnLengde() {
		//er felles for både fornavn og etternavn
		String Over20 = "Dennetekstenerover20t";
		String akk20 = "Dennetekstenertsjuet";
		assertFalse(InputValidator.fornavnValidator(Over20));
		assertTrue(InputValidator.fornavnValidator(akk20));
		assertFalse(validator.etternavnValidator(Over20));
		assertTrue(validator.etternavnValidator(akk20));
	}
	//fornavn test
	
	@ParameterizedTest
	@ValueSource(strings = {"", "hansen", "Dennetekstenerovertsjuetegn"})
	public void uGyldigForrnavnInput(String input) {
		assertFalse(validator.etternavnValidator(input));
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"DennetekstenerakkNT",  "Hans-Hansen"})
	public void GyldigFornavnInput(String input) {
		assertTrue(validator.fornavnValidator(input));
		
	}
	
	//etternavn test
	
	@ParameterizedTest
	@ValueSource(strings = {"DennetekstenerakkNT", "Hans-Hansen", "Pedersen"})
	public void GyldigEtternavnInput(String input) {
		assertTrue(validator.etternavnValidator(input));
		
	}
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"", "hansen", "Dennetekstenerovertjue"})
	public void uGyldigEtternavnInput(String input) {
		assertFalse(validator.etternavnValidator(input));
		
	}
	
	//mobil test
	
	@ParameterizedTest
	@ValueSource(strings = {"1234567", "123456789"})
	public void uGyldigMobilInput(String input) {
		assertFalse(validator.mobilValidator(input));
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"12345678", "23456789"})
	public void gyldigMobil(String input) {
		assertTrue(validator.mobilValidator(input));
	}
	
	//passord test
	
	@ParameterizedTest
	@ValueSource(strings = {"fire", "fem"})
	public void uGyldigPassord(String input) {
		assertFalse(validator.passordValidator(input));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "firen", "femto"})
	public void gyldigPassord(String input) {
		assertTrue(validator.passordValidator(input));
	}
	
	//repetertPassord test
	
	@Test
	public void gyldigRepetertPassord() {
		String passord = "passord";
		String input = "passord";
		assertTrue(validator.passordRepetertValidator(passord, input));
	}
	@Test
	public void uGyldigRepetertPassord() {
		String passord = "passord";
		String input = "passord1";
		assertFalse(validator.passordRepetertValidator(input, passord));
	}
	
	//tester hash validator
	
	@Test
	public void validerMedSaltTest() {
		String passord = "suhin";
		String salt = passordUtil.genererTilfeldigSalt();
		String hash = passordUtil.hashMedSalt(passord, salt);
		
		
		boolean passV = hash.equals(passordUtil.hashMedSalt(passord, salt));
		assertTrue(passV);
	}
}
