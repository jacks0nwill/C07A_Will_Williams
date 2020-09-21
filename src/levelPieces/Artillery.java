package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Artillery extends GamePiece {
	//Artillery shoots at the player from a distance of 3 or 4 spaces away
	public Artillery(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation +3 ==super.getLocation() || playerLocation - 3 ==super.getLocation() || playerLocation +4 ==super.getLocation() || playerLocation - 4 ==super.getLocation()) {
			return(InteractionResult.HIT);
		}
		else {
			return(InteractionResult.NONE);
		}
	}
	public String toString() {
		return (super.toString() + "(shoots at the player from a distance)");
	}

}
