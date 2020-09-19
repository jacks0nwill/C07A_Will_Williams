package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Tiger extends GamePiece implements Moveable{
	
	public Tiger(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation==super.getLocation() || playerLocation +1 ==super.getLocation() || playerLocation - 1 ==super.getLocation()) {
			return(InteractionResult.KILL);
		}
		else {
			return(InteractionResult.NONE);
		}
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[super.getLocation()] = null;
		//TODO verify if space in front of tiger is open to move, if not remain in place
		if (playerLocation-1 > super.getLocation()) {
			if((gameBoard[super.getLocation()+1]) == null) {
				super.setLocation(super.getLocation()+1);
			}
			
		}
		if (playerLocation+1 < super.getLocation()) {
			if((gameBoard[super.getLocation()-1]) == null) {
				super.setLocation(super.getLocation()-1);
			}
		}
		
		gameBoard[super.getLocation()] = this;
	}
	

}
