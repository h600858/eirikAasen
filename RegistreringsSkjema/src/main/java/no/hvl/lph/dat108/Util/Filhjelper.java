package no.hvl.lph.dat108.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Filhjelper {

	public static List<String> lesInnPassordFraFil(String filnavn) throws IOException {
		return Files.lines(Paths.get(filnavn)).toList();
	}

}
