package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
	//Tiger kills a player on one side or the other or on top of it
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
	//Tiger always moves towards a play unless they are blocked
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[super.getLocation()] = null;
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
	public String toString() {
		return (super.toString() + "(DANGEROUS, will kill you!)");
	}


}
