package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Artillery;
import levelPieces.Coin;
import levelPieces.GreenPipe;
import levelPieces.Hermit;
import levelPieces.Tiger;

class TestInteractions {


	/*
     * Test that Artillery hits player (interaction) only when player is 3 or 4 spaces away
    */
    @Test
    public void testArtillery() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Artillery art = new Artillery('A', "Artillery", 10);
		gameBoard[10] = art;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, art.interact(gameBoard, 13));
		assertEquals(InteractionResult.HIT, art.interact(gameBoard, 14));
		assertEquals(InteractionResult.HIT, art.interact(gameBoard, 7));
		assertEquals(InteractionResult.HIT, art.interact(gameBoard, 6));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<6; i++)
			assertEquals(InteractionResult.NONE, art.interact(gameBoard, i));
		for (int i=15; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, art.interact(gameBoard, i));
		for (int i=8; i<13; i++)	
			assertEquals(InteractionResult.NONE, art.interact(gameBoard, i));
	}
    /*
     * Test that coin gives player a point (interaction) only when player is on same location
    */
    
    @Test
    public void testCoin() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Coin coin = new Coin('C', "Coin", 10);
		gameBoard[10] = coin;
		// Hit points if player on same space
		assertEquals(InteractionResult.GET_POINT, coin.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, coin.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, coin.interact(gameBoard, i));
	}	
    /*
     * Test that Green Pipe advances player a level (interaction) only when player is on same location
    */
    
    @Test
    public void testGreenPipe() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		GreenPipe GP = new GreenPipe('G', "GreenPipe", 10);
		gameBoard[10] = GP;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, GP.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, GP.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, GP.interact(gameBoard, i));
	}	
    
    /*
     * Test that Hermit hits player (interaction) only when player is on same location
    */
    
    @Test
    public void testHermit() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Hermit herm = new Hermit('H', "Hermit", 10);
		gameBoard[10] = herm;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, herm.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, herm.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, herm.interact(gameBoard, i));
	}	
    
    /*
     * Test that Tiger kills player (interaction) only when player is on same location or one adjacent
    */
    
    @Test
    public void testTiger() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Tiger tig = new Tiger('T', "Tiger", 10);
		gameBoard[10] = tig;
		// Hit points if player on same space
		assertEquals(InteractionResult.KILL, tig.interact(gameBoard, 11));
		assertEquals(InteractionResult.KILL, tig.interact(gameBoard, 9));
		assertEquals(InteractionResult.KILL, tig.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<9; i++)
			assertEquals(InteractionResult.NONE, tig.interact(gameBoard, i));
		for (int i=12; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, tig.interact(gameBoard, i));
	}	

}
