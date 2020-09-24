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
	 * Tests motion, used by Tiger and Hermit.
	 * Strategy: 
	 * - Trap the hermit to ensure he does not move over other pieces
	 * - Ensure tiger is blocked on way to player.
	 * - Test that the pieces wont leave the board
	 * - Test that hermit moves both directions
	 */
	@Test
	public void testHermitMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			
		Hermit hermit = new Hermit('H', "Hermit", 10);
		gameBoard[10] = hermit;
		int count1 = 0;
		int count2 = 0;
		int loc =0;
		for (int i=0; i<200; i++) {//tests the hermit's movement randomly to ensure it moves both directions and doesn't leave the board
			int before=loc;
			hermit.move(gameBoard, 13);
			loc = hermit.getLocation();
			// counters to ensure every valid option is chosen
			if (loc == before+1) count1++;
			if (loc == before-1) count2++;
			if (loc<0 || loc>20)
				fail("Invalid square selected");
		}
		assert(count1 > 1);
		assert(count2 > 1);
		
		gameBoard[9] = new PaperWeight('P', "PaperWeight", 9);
		gameBoard[11] = new PaperWeight('P', "PaperWeight", 11);//tests the hermit's movement randomly to ensure it does not move over top of another object
		for (int i=0; i<200; i++) {
			hermit.move(gameBoard, 13);
			int loc2 = hermit.getLocation();
			// ensure no invalid
			if (loc2 == 9 || loc2 == 11 )
				fail("Invalid square selected");
		}

	}
	@Test
	public void testTigerMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Tiger tiger = new Tiger('T', "Tiger", 10);
		gameBoard[10] = tiger;
		for (int i=0; i<10; i++) {
			tiger.move(gameBoard, 20);///tests the Tigers's movement to ensure it does not move off the board
			int loc = tiger.getLocation();
			if (loc < 10 || loc > 20)
				fail("Invalid square selected");
		}
		gameBoard[11] = new PaperWeight('P', "PaperWeight", 11);//tests the Tigers's movement to ensure it does not move over top of another object to reach the player
		for (int i=0; i<200; i++) {
			tiger.move(gameBoard, 1);
			int loc2 = tiger.getLocation();
			if (loc2< 11)
				fail("Invalid square selected");

		}
	}
}
