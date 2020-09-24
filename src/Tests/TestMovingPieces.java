package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Hermit;
import levelPieces.PaperWeight;
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
	public void testHermitMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			
		Hermit hermit = new Hermit('H', "Hermit", 10);
		gameBoard[10] = hermit;
		int count1 = 0;
		int count2 = 0;
		int loc =0;
		for (int i=0; i<200; i++) {
			int before=loc;
			hermit.move(gameBoard, 13);
			loc = hermit.getLocation();
			if (loc == before+1) count1++;
			if (loc == before-1) count2++;
		}
		assert(count1 > 1);
		assert(count2 > 1);
		
		gameBoard[9] = new PaperWeight('P', "PaperWeight", 9);
		gameBoard[11] = new PaperWeight('P', "PaperWeight", 11);
		for (int i=0; i<200; i++) {
			hermit.move(gameBoard, 13);
			int loc2 = hermit.getLocation();
			// ensure no other space is chosen
			if (loc2 == 9 || loc2 == 11 || loc2<0 || loc2>20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
		}

	}
	@Test
	public void testTigerMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Tiger tiger = new Tiger('T', "Tiger", 10);
		gameBoard[10] = tiger;
		for (int i=0; i<10; i++) {
			tiger.move(gameBoard, 20);
			int loc = tiger.getLocation();
			if (loc < 10 || loc > 20)
				fail("Invalid square selected");
		}
		gameBoard[11] = new PaperWeight('P', "PaperWeight", 11);
		for (int i=0; i<200; i++) {
			tiger.move(gameBoard, 1);
			int loc2 = tiger.getLocation();
			if (loc2< 11)
				fail("Invalid square selected");

		}
	}
}
