package edu.elsmancs.arteco;

public class Main {

	public static void main(String[] args) {
		String loren = Crawler.mockURL();
		Logica.totalWords(loren);
		Logica.totalPhrases(loren);
		Logica.totalParagraphs(loren);
		Logica.totalPalindroms(loren);
	}
}