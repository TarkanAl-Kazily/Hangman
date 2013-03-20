/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	private static final int BODY_PARTS = 8;
	
    public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    }
	
	public void run() {
		canvas.reset();
    	boolean correct;
    	char guess;
    	for (int i = 0; i < wordLength; i++) {
    		currentStr[i] = '-';
    	}  	
    	println("Welcome to Hangman!");
    	while (remGuess > 0){
    		display = createDisplay(currentStr);
    		if (display.equals(str)) {
    			victory = true;
    			break;
    		}
	    	println("The word now looks like this: " + display);
	    	println("You have " + remGuess + " guess left.");
	    	guess = createGuess();
	    	correct = false;
	    	for (int i = 0; i < wordLength; i++) {
	    		if (guess == str.charAt(i)) {
	    			currentStr[i] = guess;
	    			correct = true;
	    		}
	    	}
    		if (correct) {
	    		println("That guess is correct.");
	    	} else {
	    		remGuess--;
	    		canvas.noteIncorrectGuess(guess);
	    		println("There are no " + guess + "'s in the word.");
    		}
	    }
		if (!victory) {
			println("You're completely hung.\nThe word was: " + str + "\nYou lose.");
		} else {
			println("You guessed the word: " + str + "\nYou win.");
		}
	}
    
    private char createGuess() {
    	char guess = ' ';
    	boolean legitimateGuess = false;
    	while (!legitimateGuess) {
	    	guess = readLetter("Your guess: ");
	    	legitimateGuess = true;
	    	for (char letter : guessed) {
	    		if (letter == guess) {
	    			println("You have already guessed that letter.");
	    			legitimateGuess = false;
	    			break;
	    		}
	    	}
    	}
    	guessed.add(guess);
    	return guess;
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
			println("That is not a character.");
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
    
    private String createDisplay(char[] arr) {
    	display = "";
    	for (int i = 0; i < wordLength; i++) {
    		display += arr[i];
    	}
    	return display;
    }
    
    private boolean victory = false;
    private int remGuess = BODY_PARTS;
    private int index = (int) (Math.random() * HangmanLexicon.getWordCount());
    private String str = HangmanLexicon.getWord(index);
    private int wordLength = str.length();
	private char[] currentStr = new char[wordLength];
	private String display;
	private java.util.List<Character> guessed = new ArrayList<Character>();
	private HangmanCanvas canvas;
    
}
