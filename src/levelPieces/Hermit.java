package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

//angry bees move twoards the player if the player is withn 3 tiles of them
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
		//TODO verify if space in front of tiger is open to move, if not remain in place
		
	}
	

}
