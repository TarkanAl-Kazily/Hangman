/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import java.util.*;
import java.lang.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		add(scaffold);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		wrongGuesses.add(letter);
		wrongGuessesStr = "";
		for (char ch: wrongGuesses) {
			wrongGuessesStr += ch;
		}
		switch (wrongGuesses.size()) {
			case 1: {
				add(head);
				break;
			} case 2: {
				add(body);
				break;
			} case 3: {
				add(leftArm);
				break;
			} case 4: {
				add(rightArm);
				break;
			} case 5: {
				add(leftLeg);
				break;
			} case 6: {
				add(rightLeg);
				break;
			} case 7: {
				add(leftFoot);
				break;
			} case 8: {
				add(rightFoot);
				break;
			}
		}
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int OFFSET = 40;
	
	private GObject vScaffold = new GLine(OFFSET, (SCAFFOLD_HEIGHT + OFFSET), OFFSET, OFFSET);
	private GObject beam = new GLine(OFFSET, OFFSET, (BEAM_LENGTH + OFFSET), OFFSET);
	private GObject rope = new GLine((BEAM_LENGTH + OFFSET), OFFSET, (BEAM_LENGTH + OFFSET), (ROPE_LENGTH + OFFSET));
	private GObject scaffold = new GCompound(); {
		((GCompound) scaffold).add(vScaffold);
		((GCompound) scaffold).add(beam);
		((GCompound) scaffold).add(rope);
	}
	
	private GObject head = new GOval(((BEAM_LENGTH + OFFSET) - HEAD_RADIUS), (ROPE_LENGTH + OFFSET), (2 * HEAD_RADIUS), (2 * HEAD_RADIUS));
	private GObject body = new GLine((BEAM_LENGTH + OFFSET), ((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)), (BEAM_LENGTH + OFFSET), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH));
	
	private GObject leftUpperArm = new GLine((BEAM_LENGTH + OFFSET), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD), ((BEAM_LENGTH + OFFSET) - UPPER_ARM_LENGTH) ,(((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD));
	private GObject rightUpperArm = new GLine((BEAM_LENGTH + OFFSET), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD), ((BEAM_LENGTH + OFFSET) + UPPER_ARM_LENGTH) ,(((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD));
	private GObject leftLowerArm = new GLine(((BEAM_LENGTH + OFFSET) - UPPER_ARM_LENGTH), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD), ((BEAM_LENGTH + OFFSET) - UPPER_ARM_LENGTH), ((((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD) + LOWER_ARM_LENGTH));
	private GObject rightLowerArm = new GLine(((BEAM_LENGTH + OFFSET) + UPPER_ARM_LENGTH), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD), ((BEAM_LENGTH + OFFSET) - UPPER_ARM_LENGTH), ((((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + ARM_OFFSET_FROM_HEAD) + LOWER_ARM_LENGTH));
	private GObject leftArm = new GCompound(); {
		((GCompound) leftArm).add(leftUpperArm);
		((GCompound) leftArm).add(leftLowerArm);
	} private GObject rightArm = new GCompound(); {
		((GCompound) rightArm).add(rightUpperArm);
		((GCompound) rightArm).add(rightLowerArm);
	}
	
	//Endpoint of body: (BEAM_LENGTH + OFFSET), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH)
	private GObject upperLeftLeg = new GLine((BEAM_LENGTH + OFFSET), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH), ((BEAM_LENGTH + OFFSET) - HIP_WIDTH), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH));
	private GObject upperRightLeg = new GLine((BEAM_LENGTH + OFFSET), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH), ((BEAM_LENGTH + OFFSET) + HIP_WIDTH), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH));
	private GObject lowerLeftLeg = new GLine(((BEAM_LENGTH + OFFSET) - HIP_WIDTH), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH), ((BEAM_LENGTH + OFFSET) - HIP_WIDTH), ((((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH) + LEG_LENGTH));
	private GObject lowerRightLeg = new GLine(((BEAM_LENGTH + OFFSET) + HIP_WIDTH), (((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH), ((BEAM_LENGTH + OFFSET) + HIP_WIDTH), ((((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH) + LEG_LENGTH));
	private GObject leftLeg = new GCompound(); {
		((GCompound) leftLeg).add(upperLeftLeg);
		((GCompound) leftLeg).add(lowerLeftLeg);
	} private GObject rightLeg = new GCompound(); {
		((GCompound) rightLeg).add(upperRightLeg);
		((GCompound) rightLeg).add(lowerRightLeg);
	}
	
	private GObject leftFoot = new GLine(((BEAM_LENGTH + OFFSET) - HIP_WIDTH), ((((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH) + LEG_LENGTH), (((BEAM_LENGTH + OFFSET) - HIP_WIDTH) - FOOT_LENGTH), ((((ROPE_LENGTH + OFFSET) - (2 * HEAD_RADIUS)) + BODY_LENGTH) + LEG_LENGTH));
	
	private List<Character> wrongGuesses = new ArrayList<Character>();
	private String wrongGuessesStr;








}
