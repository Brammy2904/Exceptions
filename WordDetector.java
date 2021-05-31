package Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordDetector {
	public void FileAfprinten(String pad) {
		try {
			String data = "";
			File bestand = new File(pad);
			Scanner myReader = new Scanner(bestand);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
	}catch (FileNotFoundException e) {
		System.out.println("File niet gevonden");
	}
	}
	public void WoordZoeken(String pad) throws WoordNietGevondenException {
		try {
			String data = "";
			String GevraagdWoord;
			int counter = 0;
			System.out.println("Welk woord wil je zoeken?");
			Scanner m = new Scanner(System.in);
			GevraagdWoord = m.nextLine();
			File bestand = new File(pad);
			Scanner myReader = new Scanner(bestand);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				if (data.contains(GevraagdWoord)) {
					counter++;
				}
			}
			myReader.close();
			if(counter == 0) {
				throw new WoordNietGevondenException("woord niet gevonden");
			}
			System.out.println("Uw woord komt " + counter + " keer voor in het hele document.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File niet gevonden.");
		}
	}
}
