package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tiger extends GamePiece{
	
	public Tiger(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
	}

	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation==super.getLocation() || playerLocation +1 ==super.getLocation() || playerLocation - 1 ==super.getLocation()) {
			return(InteractionResult.KILL);
		}
		else {
			return(InteractionResult.NONE);
		}
	}
	

}
