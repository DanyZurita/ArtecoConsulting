package edu.elsmancs.arteco;

import java.util.StringTokenizer;

public class Logica {
	
	public static Integer totalWords(String loren) {
		StringTokenizer st = new StringTokenizer(loren);
		Integer numWords = st.countTokens();
		System.out.println ("palabras: " + numWords);
		return numWords;
	}
	
}
