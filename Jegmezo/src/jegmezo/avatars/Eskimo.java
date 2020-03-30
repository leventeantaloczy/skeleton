package jegmezo.avatars;

import jegmezo.Direction;

public class Eskimo extends Avatar{
	
	
	public Eskimo() {
		super(5);
	}
	
	public int specialMove(Direction d) {
		System.out.println("<Eskimo.build()");
		System.out.println(">Eskimo.build()");
		return 1;
	}

}
