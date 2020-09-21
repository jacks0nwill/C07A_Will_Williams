package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece {
	//Coin gives a point if the player lands on it
	public Coin(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation==super.getLocation()) {
			return(InteractionResult.GET_POINT);
		}
		else {
			return(InteractionResult.NONE);
		}
	}

}
