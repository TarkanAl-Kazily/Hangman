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

private static final int BODY_PARTS = 8;

public class Hangman extends ConsoleProgram {

    public void run() {
    	int index = (int) (Math.random() * HangmanLexicon.getWordCount());
    	String str = HangmanLexicon.getWord(index);
    	
	}
    
    
    
    private char readChar(String display) {
		String input = readLine(display);
		while (input.length() != 1) {
			println("Error: Not a character");
			input = readLine(display);
		}
		return input.charAt(0);
	}
    
}
