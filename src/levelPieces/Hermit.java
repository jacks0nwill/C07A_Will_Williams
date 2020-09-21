package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import java.util.Random;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

//hermit moves randomly by one space if the player lands on them they hit the player
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
		gameBoard[super.getLocation()] = null;
		Random rand= new Random();
		int r = rand.nextInt(10);
		//50/50 chance to move left or right
		if((r % 2) == 0) {
			if(((super.getLocation()+1) < GameEngine.BOARD_SIZE) && (gameBoard[super.getLocation()+1] == null)) {
				super.setLocation(super.getLocation() + 1);
			}
		}else{
			if(((super.getLocation()-1) > 0) && (gameBoard[super.getLocation()-1] == null)) {
				super.setLocation(super.getLocation() - 1);
			}
		}
		
		gameBoard[super.getLocation()] = this;
	}
	

}
