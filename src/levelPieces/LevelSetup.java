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
			

			Coin C = new Coin('C', "Coin", 18);
			board[C.getLocation()] = C;
			interactingPieces.add(C);
			
			Coin C2 = new Coin('C', "Coin", 6);
			board[C2.getLocation()] = C2;
			interactingPieces.add(C2);
			
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
			Artillery A = new Artillery('A', "Artillery", 0);
			board[A.getLocation()] = A;
			interactingPieces.add(A);
			
			PaperWeight P= new PaperWeight('W', "PaperWeight", 2);
			board[P.getLocation()] = P;
			
			Coin C = new Coin('C', "Coin", 5);
			board[C.getLocation()] = C;
			interactingPieces.add(C);
			
			Coin C2 = new Coin('C', "Coin", 16);
			board[C2.getLocation()] = C2;
			interactingPieces.add(C2);
			
			Tiger T = new Tiger('T', "Tiger", 20);
			board[T.getLocation()] = T;
			movingPieces.add(T);
			interactingPieces.add(T);
			
			Hermit H = new Hermit('H', "Hermit", 14);
			board[H.getLocation()] = H;
			movingPieces.add(H);
			interactingPieces.add(H);
			
			Hermit H2 = new Hermit('H', "Hermit", 8);
			board[H2.getLocation()] = H2;
			movingPieces.add(H2);
			interactingPieces.add(H2);
			
		}
	}
	
}
