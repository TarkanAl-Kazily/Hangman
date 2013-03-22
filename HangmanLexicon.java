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

	public static void setup() {
		FileReader fp=null;
		System.out.println("opening file...");
		try {
			fp = new FileReader("ShorterLexicon.txt");
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
			System.out.println(word);
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
