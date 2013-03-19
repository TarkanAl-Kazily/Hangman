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
    	for (int i = 0; i < currentStr.length; i++) {
    		currentStr[i] = "-";
    	}  	
    	println("Welcome to Hangman!");
    	while (remGuess > 0){
	    	println("The word now looks like this: " + );
	    	println("You have " + remGuess + " guess left.");
	    	char guess = readLetter("Your guess: ");
	    	boolean correct = false;
	    	//Use array to store chars that have been successfully guessed, and dashes in places that havent.
	    	for (int i = 0; i < str.length(); i++) {
	    		if (guess == str.charAt(i)) {
	    			
	    			correct = true;
	    		} else {
	    			
	    		}
	    	}
	    	if (correct) {
	    		println("That guess is correct.");
	    	} else {
	    		remGuess--;
	    		println("There are no " + guess + "'s in the word.");
	    	}
	    	
    	}
    	if (!victory) {
    		println("You're completely hung.\nThe word was: " + str + "\nYou lose.");
    	} else {
    		println("You guessed the word: " + str + "\nYou win.");
    	}
	}
    
    private char readLetter(String display) {
    	char ch = '!';
    	while (!isLetter(ch)) {
    		ch = readChar(display);
    		if (isLetter(ch)) {
    			break;
    		}
    		println("That is not a letter.");
    	}
    	if (!isCapital(ch)) {
    		ch += (int) ('A' - 'a');
    	}
    	return ch;
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
    
    private boolean victory = false;
    private int remGuess = BODY_PARTS;
    private int index = (int) (Math.random() * HangmanLexicon.getWordCount());
    private String str = HangmanLexicon.getWord(index);
	private String[] currentStr = new String[str.length()];
    
}
