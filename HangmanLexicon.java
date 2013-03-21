/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class HangmanLexicon {

	public static setup() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			String word = br.readLine();
			while (word != null) {
				words.add(word);
				word = br.readLine();
			}
			br.close();
		} catch (IOException e) {}
		
	}
	
/** Returns the number of words in the lexicon. */
	public static int getWordCount() {
		return words.size();
	}

/** Returns the word at the specified index. */
	public static String getWord(int index) {
		return words.get(index);
//		switch (index) {
//			case 0: return "BUOY";
//			case 1: return "COMPUTER";
//			case 2: return "CONNOISSEUR";
//			case 3: return "DEHYDRATE";
//			case 4: return "FUZZY";
//			case 5: return "HUBBUB";
//			case 6: return "KEYHOLE";
//			case 7: return "QUAGMIRE";
//			case 8: return "SLITHER";
//			case 9: return "ZIRCON";
//			default: throw new ErrorException("getWord: Illegal index");
//		}
	}
	
	
	private static List<String> words = new ArrayList<String>();
	
}
