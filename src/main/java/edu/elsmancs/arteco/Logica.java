package edu.elsmancs.arteco;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
		int i = 0;
		
		for (int end = bi.next();
		     end != BreakIterator.DONE;
		     index = end, end = bi.next()) {
			sentence = lorenClean.substring(index,end);
			i++;
		    System.out.println("\nSentence "+ i + ": " + sentence);
		    
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
		String lorenClean = removePHtmlNotations(loren.replaceAll("\\.", "")).toLowerCase();
		StringTokenizer st = new StringTokenizer(lorenClean);
		List<String> palindromosList = new ArrayList<String>();
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
	    	  palindromosList.add(word);
		      }
		}
		
		System.out.print("Palindromos: " + palindromosList + "\nTotal palindromos: "+ palindromosList.size());
		return palindromosList.size();
	}
	
	public static Map<String, Integer> topWords(String loren, int topMax) {
		final int TOP = topMax;
		Map<String, Integer> words = new HashMap<String, Integer>();
		String lorenClean = removePHtmlNotations(loren.replaceAll("\\.", "")).toLowerCase();
		StringTokenizer st = new StringTokenizer(lorenClean);
		//Crear HashMap con el acumulador por repetición
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			words.compute(token, (word, count) -> {if (count == null)
                return 1;
            return count + 1;});
		}
		
		//Lista para saber las palabras que más se repiten del HashMap
		List<Integer> topCounts = words.values().stream()
							                .sorted(Comparator.reverseOrder())
							                .limit(TOP)
							                .collect(Collectors.toList());
		
		//Guardar estado original del contador anterior
		final List<Integer> topCounts2 = words.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(TOP)
                .collect(Collectors.toList());
		
        //Lista de las palabras más repetidas
		final String[] topWords = new String[TOP];
        words.forEach((word, count) -> {
            int indexOfWord = topCounts.indexOf(count);
            if (indexOfWord > -1) {
                topWords[indexOfWord] = word;
                topCounts.set(indexOfWord, -1);
            }
        });
        System.out.println("\nTop 5 palabras más repetidas: " + Arrays.toString(topWords) + "\nRespectivas cuentas: " + topCounts2);
		return words;
	}
}
