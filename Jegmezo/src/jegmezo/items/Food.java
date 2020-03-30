package jegmezo.items;

import jegmezo.avatars.Avatar;

public class Food extends Item{

	@Override
	public void use(Avatar a) {
		System.out.println("<Food.use()");
		a.gainHealth();
		System.out.println(">Food.use()");
		
	}
	
}
