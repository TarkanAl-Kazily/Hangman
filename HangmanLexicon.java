/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.util.*;
import java.io.*;

public class HangmanLexicon {

	public static void setup() {
		FileReader fp=null;
		try {
			fp = new FileReader("HangmanLexicon.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found!" + e);
		}
		BufferedReader br = new BufferedReader(fp);
		String word="";
		try {
			word = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("readLine exception");
			e.printStackTrace();
		}
		while (word != null) {
			words.add(word);
			try {
				word = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
/** Returns the number of words in the lexicon. */
	public static int getWordCount() {
		return words.size();
	}

/** Returns the word at the specified index. */
	public static String getWord(int index) {
		return words.get(index);
	}
	
	
	private static List<String> words = new ArrayList<String>();
	
}
