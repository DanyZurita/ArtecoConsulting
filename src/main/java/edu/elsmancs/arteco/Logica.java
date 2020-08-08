package edu.elsmancs.arteco;

import java.text.BreakIterator;
import java.util.StringTokenizer;

public class Logica {
	
	public static Integer totalWords(String loren) {
		String lorenClean = removePHtmlNotations(loren);
		StringTokenizer st = new StringTokenizer(lorenClean);
		Integer numWords = st.countTokens();
		System.out.println ("Palabras: " + numWords);
		return numWords;
	}
	
	public static Integer totalPhrases(String loren) {
		String lorenClean = removePHtmlNotations(loren);
		BreakIterator bi = BreakIterator.getSentenceInstance();
		bi.setText(lorenClean);
		Integer numPhrases = 0;
		int index = bi.first();
		String sentence = "";
		
		for (int end = bi.next();
		     end != BreakIterator.DONE;
		     index = end, end = bi.next()) {
			sentence = lorenClean.substring(index,end);
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
	
	private static String removePHtmlNotations(String loren) {
		String lorenClean = loren.replaceAll("<p>", "");
		lorenClean = lorenClean.replaceAll("</p>", "");
		return lorenClean;
	}
	
	public static Integer totalPalindroms(String loren) {
		Integer numPalindroms = 0;
		String lorenClean = removePHtmlNotations(loren.replaceAll("\\.", "")).toLowerCase();
		StringTokenizer st = new StringTokenizer(lorenClean);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			int i = 0;
			int begin  = 0;
		    int end = word.length() - 1;
		    int middle = (begin + end)/2;
		 
		    for (i = begin; i <= middle; i++) {
		      if (word.charAt(begin) == word.charAt(end)) {
		        begin++;
		        end--;
		      }
		      else
		        break;
		    }
		    //Descartar palindromos de menos de 3 chars
		    if (i == middle + 1 && middle >= 1) {
	    	  numPalindroms++;
	    	  System.out.println ("Palabra palindroma: " + word);
		      }
		}
		
		System.out.print("Palindromos: " + numPalindroms);
		return numPalindroms;
	}
	
}
