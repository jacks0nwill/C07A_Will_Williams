package gameEngine;

import java.util.ArrayList;

import levelPieces.GamePiece;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList movingPieces;
	private ArrayList interactingPieces;
	private static int startingLocation;
	//TODO createLevel()
	public LevelSetup() {
		super();
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
	
}
