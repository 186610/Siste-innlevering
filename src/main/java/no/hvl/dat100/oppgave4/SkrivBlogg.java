package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		PrintWriter skriver = null;
		Path mappePath = Paths.get(mappe);
		
		try {
			if (!Files.exists(mappePath, LinkOption.NOFOLLOW_LINKS)) {
				Files.createDirectories(mappePath);
			}
				
		} catch (IOException e) {
			return false;
		}
		
		
		try {
			skriver = new PrintWriter(mappePath.resolve(filnavn).toString());
			skriver.print(samling);
		} catch (FileNotFoundException e) {
			return false;
		} finally {
			if (skriver != null) {
				skriver.close();
			}
		}
		
		return true;
	}

}
