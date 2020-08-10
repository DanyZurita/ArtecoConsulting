package edu.elsmancs.arteco;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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
	
	static String removePHtmlNotations(String loren) {
		String lorenClean = loren.replaceAll(" <p> ", " ");
		lorenClean = lorenClean.replaceAll(" </p> ", " ");
		return lorenClean;
	}
	
	public static Integer totalPalindroms(String loren) {
		String lorenClean = removePHtmlNotations(loren.replaceAll("\\.", "")).toLowerCase();
		StringTokenizer st = new StringTokenizer(lorenClean);
		List<String> palindromosList = new ArrayList<String>();
		
		//Buscar todos los palindromos
		palindromosList = countAllPalindroms(st, palindromosList);
		
		System.out.print("Palindromos: " + palindromosList + "\nTotal palindromos: "+ palindromosList.size());
		return palindromosList.size();
	}
	
	public static String[] topWords(String loren, int topMax) {
		final int TOP = topMax;
		Map<String, Integer> words = new HashMap<String, Integer>();
		String lorenClean = removePHtmlNotations(loren.replaceAll("\\.", "")).toLowerCase();
		StringTokenizer st = new StringTokenizer(lorenClean);
		//Crear HashMap con el acumulador por repetición
		words = countAllWords(st, words);
		
		//Lista para saber las palabras que más se repiten del HashMap
		final List<Integer> topCounts = topCounts(words, TOP);
		
        //Lista de las palabras más repetidas
		final String[] topWords = getTopString(words, TOP);
		
        System.out.println("\nTop 5 palabras más repetidas: " + Arrays.toString(topWords) + "\nRespectivas cuentas: " + topCounts);
		return topWords;
	}
	
	public static Map<String, Integer> topTuples(String lorem, int topMax) {
		final int TOP = topMax;
		Map<String, Integer> tuples = new HashMap<String, Integer>();
		List<String> loremList = loremList(lorem);
		Iterator<String> it = loremList.iterator();   
		
		//Añadir las tuplas al Hashmap
		it = findTuples(it, tuples);
		
		//Lista para saber las palabras que más se repiten del HashMap
		final List<Integer> topCounts = topCounts(tuples, TOP);
		
        //Lista de las palabras más repetidas
		final String[] topTuples = getTopString(tuples, TOP);
		
        System.out.println("Top " + TOP + " tuplas más repetidas: " + Arrays.toString(topTuples) + "\nRespectivas cuentas: " + topCounts);
		return tuples;
	}
	
	private static List<String> loremList(String lorem) {
		String lorenClean = removePHtmlNotations(lorem.replaceAll("\\.", "")).toLowerCase();
		StringTokenizer st = new StringTokenizer(lorenClean);
		List<String> output = new ArrayList<String>();
		//Crear ArrayList con todas las palabras
		while (st.hasMoreTokens()) {
			output.add(st.nextToken());
		}
		return output;
	}
	
	private static String[] getTopString(Map<String, Integer> map, int TOP) {
		List<Integer> topCounts = topCounts(map, TOP);
		final String[] topString = new String[TOP];
		map.forEach((key, count) -> {
            int index = topCounts.indexOf(count);
            if (index > -1) {
                topString[index] = key;
                topCounts.set(index, -1);
            }
        });
		return topString;
	}
	
	private static List<Integer> topCounts(Map<String, Integer> map, int TOP) {
		return map.values().stream()
        .sorted(Comparator.reverseOrder())
        .limit(TOP)
        .collect(Collectors.toList());
	}
	
	private static Iterator<String> findTuples(Iterator<String> it, Map<String, Integer> map) {
		String currentWord = null;
		String previousWord = null;
		while( it.hasNext() ) {
			  currentWord = it.next();
			  if( previousWord != null ) {
			    String key = previousWord.concat( " " ).concat( currentWord );
			    if( map.containsKey( key ) ) {
			      Integer lastCount = map.get( key );
			      map.put( key, lastCount + 1 );
			    } else {
			      map.put( key, 1 );
			    }
			  }
			  previousWord = currentWord;
			}
		return it;
	}
	
	private static Map<String, Integer> countAllWords(StringTokenizer st, Map<String, Integer> map) {
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			map.compute(token, (word, count) -> {if (count == null)
	            return 1;
	        return count + 1;});
		}
		return map;
	}
	
	private static List<String> countAllPalindroms(StringTokenizer st, List<String> list) {
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
	    	  list.add(word);
		      }
		}
		return list;
	}
}
