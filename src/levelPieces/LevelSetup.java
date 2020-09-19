package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList movingPieces;
	private ArrayList interactingPieces;
	private static int startingLocation;
	//TODO createLevel()
	public LevelSetup() {
		super();
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<GamePiece>();
		interactingPieces = new ArrayList<GamePiece>();
		startingLocation = 11;
	}
	public Drawable[] getBoard() {
		return board;
	}
	public ArrayList getMovingPieces() {
		return movingPieces;
	}
	public ArrayList getInteractingPieces() {
		return interactingPieces;
	}
	public int getPlayerStartLoc() {
		return(startingLocation);
	}
	public void createLevel(int level) {
		if (level==1) {
			PaperWeight P= new PaperWeight('W', "Paper Weight", 5);
			for( int i=0; i<GameEngine.BOARD_SIZE; i++) {
				if(i == P.getLocation()) {
					board[i]=P;
				}
			}
		}
		if (level==2) {
			PaperWeight P= new PaperWeight('W', "Paper Weight", 5);
			for( int i=0; i<GameEngine.BOARD_SIZE; i++) {
				if(i == P.getLocation()) {
					board[i]=P;
				}
			}
		}
	}
	
}
