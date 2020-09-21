package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class GreenPipe extends GamePiece {
	//if player lands on the green pipe it advances the level
	public GreenPipe(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation==super.getLocation()) {
			return(InteractionResult.ADVANCE);
		}
		else {
			return(InteractionResult.NONE);
		}
	}
	public String toString() {
		return (super.toString() + "(Transports to another dimension...)");
	}

}
