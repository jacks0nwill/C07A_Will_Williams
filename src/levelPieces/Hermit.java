package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import java.util.Random;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

//hermit moves randomly if the player lands on them they hit the player
public class Hermit extends GamePiece implements Moveable{
	
	public Hermit(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation==super.getLocation()) {
			return(InteractionResult.HIT);
		}
		else {
			return(InteractionResult.NONE);
		}
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random rand= new Random();
		while(true) {
			int pos = rand.nextInt(GameEngine.BOARD_SIZE);
			if((gameBoard[pos]) == null) {
				super.setLocation(pos);
				break;
			}
		}
		
	}
	

}
