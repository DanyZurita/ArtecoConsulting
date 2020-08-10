package edu.elsmancs.arteco;


public class Main {

	public static void main(String[] args) {
		System.out.println("\n - OBTENER LOS 5 PRIMEROS PARRAFOS - \n");
		String loren = Crawler.getURLJSoup("https://es.lipsum.com/feed/html");
		//String loren = Crawler.mockURL();
		System.out.println("\n\n - OBTENER EL TOTAL DE PALABRAS - \n");
		Logica.totalWords(loren);
		System.out.println("\n\n - OBTENER EL TOTAL DE FRASES - \n");
		Logica.totalPhrases(loren);
		System.out.println("\n\n - OBTENER EL TOTAL DE PARRAFOS - \n");
		Logica.totalParagraphs(loren);
		System.out.println("\n\n - IDENTIFICAR Y CONTAR PALÍNDROMOS - \n");
		Logica.totalPalindroms(loren);
		System.out.println("\n\n - IDENTIFICAR Y CONTAR TOP 5 PALABRAS REPETIDAS - \n");
		Logica.topWords(loren, 5);
		System.out.println("\n\n - IDENTIFICAR Y CONTAR TOP 5 TUPLAS REPETIDAS - \n");
		Logica.topTuples(loren, 5);
	}
}