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
    	while (remGuess < 0){
	    	println("The word now looks like this: " + display);
	    	println("You have " + remGuess + " left.");
	    	char guess = readChar("Your guess: ");
	    	boolean correct = false;
	    	for (int i = 0; i < str.length(); i++) {
	    		if (guess == str.charAt(i)) {
	    			display += guess;
	    			correct = true;
	    		} else {
	    			display += "_";
	    		}
	    	}
	    	if (!correct) {
	    		remGuess--;
	    	}
    	}
    	
	}
    
    
    
    private char readChar(String display) {
		String input = readLine(display);
		while (input.length() != 1) {
			println("Error: Not a character");
			input = readLine(display);
		}
		return input.charAt(0);
	}
    
    int remGuess = BODY_PARTS;
    int index = (int) (Math.random() * HangmanLexicon.getWordCount());
    String str = HangmanLexicon.getWord(index);
	String display = "";
    
}
