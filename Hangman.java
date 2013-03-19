/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	private static final int BODY_PARTS = 8;
	
    public void run() {
    	for (int i = 0; i < str.length(); i++) {
    		display += "_";
    	}
    	println("Welcome to Hangman!");
    	
	}
    
    
    
    private char readChar(String display) {
		String input = readLine(display);
		while (input.length() != 1) {
			println("Error: Not a character");
			input = readLine(display);
		}
		return input.charAt(0);
	}
    
    int index = (int) (Math.random() * HangmanLexicon.getWordCount());
	String str = HangmanLexicon.getWord(index);
	String display = "";
    
}
