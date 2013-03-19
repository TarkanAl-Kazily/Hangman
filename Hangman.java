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
    	boolean 
    	for (int i = 0; i < str.length(); i++) {
    		display += "_";
    	}
    	println("Welcome to Hangman!");
    	while (remGuess < 0){
	    	if (display.equals(str)) {
	    		victory = true;
	    		break;
	    	}
	    	println("The word now looks like this: " + display);
	    	println("You have " + remGuess + " guess left.");
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
	    	if (correct) {
	    		println("That guess is correct.");
	    	} else {
	    		remGuess--;
	    		println("There are no " + char + "'s in the word.")
	    	}
	    	
    	}
    	if (!victory) {
    		println("You're completely hung.\nThe word was: " + str + "\nYou lose.");
    	} else {
    		println("You guessed the word: " + str + "\nYou win.");
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
    
    private boolean isLetter(char ch) {
		if (((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch <= 'Z'))) return true;
		else return false;
	}
    
    private boolean isCapital(char ch) {
		if ((ch >= 'A') && (ch <= 'Z')) return true;
		else return false;
		}
	}
    
    private boolean victory = false;
    private int remGuess = BODY_PARTS;
    private int index = (int) (Math.random() * HangmanLexicon.getWordCount());
    private String str = HangmanLexicon.getWord(index);
	private String display = "";
    
}
