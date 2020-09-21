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
		board = new Drawable[GameEngine.BOARD_SIZE];//creates new board
		movingPieces = new ArrayList<GamePiece>();//creates array with moving pieces
		interactingPieces = new ArrayList<GamePiece>();//creates array with interacting pieces
		startingLocation = 11;//sets player starting location
	}
	public Drawable[] getBoard() {
		return board;
	}
	public ArrayList getMovingPieces() {//getters to access private variables
		return movingPieces;
	}
	public ArrayList getInteractingPieces() {
		return interactingPieces;
	}
	public int getPlayerStartLoc() {
		return(startingLocation);
	}
	public void createLevel(int level) {//creates one of two levels
		
		if (level==1) {
			PaperWeight P = new PaperWeight('W', "Paper Weight", 5);  //creates and assigns piece to their array and location on the board
			board[P.getLocation()] = P;
			
			Tiger T = new Tiger('T', "Tiger", 3);//creates and assigns piece to their array and location on the board
			board[T.getLocation()] = T;
			movingPieces.add(T);
			interactingPieces.add(T);
			
			Hermit H = new Hermit('H', "Hermit", 13);//creates and assigns piece to their array and location on the board
			board[H.getLocation()] = H;
			movingPieces.add(H);
			interactingPieces.add(H);
			

			Coin C = new Coin('C', "Coin", 18);//creates and assigns piece to their array and location on the board
			board[C.getLocation()] = C;
			interactingPieces.add(C);
			
			Coin C2 = new Coin('C', "Coin", 6);//creates and assigns piece to their array and location on the board
			board[C2.getLocation()] = C2;
			interactingPieces.add(C2);
			
			GreenPipe G = new GreenPipe('G', "GreenPipe", 15);//creates and assigns piece to their array and location on the board
			board[G.getLocation()] = G;
			interactingPieces.add(G);
			
			System.out.println("P - Player (You)");  //Prints information for pieces
			System.out.println(P.toString());
			System.out.println(T.toString());
			System.out.println(H.toString());
			System.out.println(C.toString());
			System.out.println(G.toString());
		}
		if (level==2) {
			for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
				board[i] = null;
			}
			movingPieces.clear();
			interactingPieces.clear();
			Artillery A = new Artillery('A', "Artillery", 0);//creates and assigns piece to their array and location on the board
			board[A.getLocation()] = A;
			interactingPieces.add(A);
			
			PaperWeight P= new PaperWeight('W', "PaperWeight", 2);//creates and assigns piece to their array and location on the board
			board[P.getLocation()] = P;
			
			Coin C = new Coin('C', "Coin", 5);//creates and assigns piece to their array and location on the board
			board[C.getLocation()] = C;
			interactingPieces.add(C);
			
			Coin C2 = new Coin('C', "Coin", 16);//creates and assigns piece to their array and location on the board
			board[C2.getLocation()] = C2;
			interactingPieces.add(C2);
			
			Tiger T = new Tiger('T', "Tiger", 20);//creates and assigns piece to their array and location on the board
			board[T.getLocation()] = T;
			movingPieces.add(T);
			interactingPieces.add(T);
			
			Hermit H = new Hermit('H', "Hermit", 14);//creates and assigns piece to their array and location on the board
			board[H.getLocation()] = H;
			movingPieces.add(H);
			interactingPieces.add(H);
			
			Hermit H2 = new Hermit('H', "Hermit", 8);//creates and assigns piece to their array and location on the board
			board[H2.getLocation()] = H2;
			movingPieces.add(H2);
			interactingPieces.add(H2);
			
			System.out.println("P - Player (You)");
			System.out.println(A.toString());
			System.out.println(P.toString());//Prints information for pieces
			System.out.println(T.toString());
			System.out.println(H.toString());
			System.out.println(C.toString());
			
		}
	}
	
}
