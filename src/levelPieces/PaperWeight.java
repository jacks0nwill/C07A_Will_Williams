package levelPieces;

import gameEngine.Drawable;

public class PaperWeight implements Drawable {
	protected char symbol;
	private String name ; 
	private int location;

		
	public PaperWeight(char symbol, String name, int location) {
		super();
		this.symbol = symbol;
		this.name = name ;
		this.location = location;
	}
		
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
		
	}
	public String toString() {
		return symbol + " - " + name ; 
	}

}
