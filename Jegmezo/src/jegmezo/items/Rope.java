package jegmezo.items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import jegmezo.Direction;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class Rope extends Item{

	/*
	 * TODO a szeki nem vilagos pls help
	 * Levente
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Rope.use()");
		
		System.out.println("Which direction? There is someone to your West, but noone in any Other direction. W/O");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String dir = null;
		try {
			dir = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(dir.toUpperCase() == "W") {
    		Field f;
    		f = a.getField().getNeighbour(Direction.West);
    		for(Avatar av : f.avatars){
    			try {
					av.move(Direction.East);
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	System.out.println(">Rope.use()");
    }
}
