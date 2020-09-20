package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList movingPieces;
	private ArrayList interactingPieces;
	private static int startingLocation;
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
		//TODO create both level setups
		if (level==1) {
			PaperWeight P = new PaperWeight('W', "Paper Weight", 5);
			board[P.getLocation()] = P;
			
			Tiger T = new Tiger('T', "Tiger", 3);
			board[T.getLocation()] = T;
			movingPieces.add(T);
			interactingPieces.add(T);
			
			Hermit H = new Hermit('H', "Hermit", 13);
			board[H.getLocation()] = H;
			movingPieces.add(H);
			interactingPieces.add(H);
			

			Award A = new Award('A', "Award", 18);
			board[A.getLocation()] = A;
			interactingPieces.add(A);
			
			GreenPipe G = new GreenPipe('G', "GreenPipe", 15);
			board[G.getLocation()] = G;
			interactingPieces.add(G);
		}
		if (level==2) {
			for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
				board[i] = null;
			}
			movingPieces.clear();
			interactingPieces.clear();
			PaperWeight P= new PaperWeight('W', "Paper Weight", 5);
			for( int i=0; i<GameEngine.BOARD_SIZE; i++) {
				if(i == P.getLocation()) {
					board[i]=P;
				}
			}
		}
	}
	
}
