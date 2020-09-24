package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Hermit;
import levelPieces.Tiger;

class TestMovingPieces {

	/*
	 * Tests random motion, used by both the Sniper and Unicorn.
	 * Strategy: 
	 * - Place pieces in all spaces EXCEPT 0, 6, 12, 13, 20.
	 * - Ensures both end spots (0 and 20) are open.
	 * - Same piece is used in all spaces, as piece identity doesn't matter.
	 * - Set player location to space 13.
	 * - Call move function many times, ensure each open space is chosen
	 *   (13 is "open" but has the player, so it should NOT be chosen)
	 */
	@Test
	public void testTigerMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Doormat();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Doormat();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Doormat();
		// Place Sniper in an open space - 6
		// Note that Sniper location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Hermit hermit = new Hermit('H', "Hermit", 10);
		gameBoard[6] = hermit;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			hermit.move(gameBoard, 13);
			int loc = hermit.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 1);
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);		
	}


}
