package edu.elsmancs.arteco;

import java.text.BreakIterator;
import java.util.StringTokenizer;

public class Logica {
	
	public static Integer totalWords(String loren) {
		StringTokenizer st = new StringTokenizer(loren);
		Integer numWords = st.countTokens();
		System.out.println ("Palabras: " + numWords);
		return numWords;
	}
	
	public static Integer totalPhrases(String loren) {
		BreakIterator bi = BreakIterator.getSentenceInstance();
		bi.setText(loren);
		Integer numPhrases = 0;
		int index = bi.first();
		String sentence = "";
		
		for (int end = bi.next();
		     end != BreakIterator.DONE;
		     index = end, end = bi.next()) {
			sentence = loren.substring(index,end);
		    //System.out.println("Sentence: " + sentence);
		    
		    //Comprueba que la frase acabe en "." para el contador
		    if (sentence.lastIndexOf(".") != -1) {
		    	numPhrases++;
		    }
		    
		}
		
		System.out.println ("Frases: " + numPhrases);
		return numPhrases;
	}
	
	public static Integer totalParagraphs(String loren) {
		Integer numParagraphs = 0;
		String busqueda = "</p>";
		while (loren.indexOf(busqueda) > -1) {
			loren = loren.substring(loren.indexOf(busqueda)+busqueda.length(),loren.length());
		    numParagraphs++; 
		}
		
		System.out.println ("Parrafos: " + numParagraphs);
		return numParagraphs;
	}
}
