package jegmezo;
import java.util.ArrayList;
import java.util.List;
import jegmezo.avatars.*;
import jegmezo.fields.*;
import jegmezo.items.*;

public class GameArea {
	List<Avatar> avatars = new ArrayList<Avatar>();	//Ez alapjan lesznek a korok (tehat, hogy ki mikor es ki utan lephet
	List<Field> fieldsOnArea = new ArrayList<Field>(); //Ez alapjan lesz, hogy hova
	int activeAvatar = 0;
	
	public GameArea(GameEnder gameEnder) {
		System.out.println("<GameArea.constructor()");
		
		/*
		* Egy jo kis init szekvencia. 
		* Felepit egy tesztpalyat field-ekbol, iteme-kbol es tesz rajuk 2 avatart. 
		* Ezen kene maszkalni es figyelni, hogy jo-e amiket kiir. 
		* Zoli
		*/
		System.out.println("Creating and adding different tipes of fields for skeletoning purpose");
		
		HoleField holeField = new HoleField();
		StableIce stableIce1 = new StableIce();
		UnstableIce unstableIce2 = new UnstableIce();
		StableIce stableIce3 = new StableIce();
		StableIce stableIce4 = new StableIce();
		StableIce stableIce5 = new StableIce();
		StableIce stableIce6 = new StableIce();
		UnstableIce unstableIce = new UnstableIce();
		Border border1 = new Border();
		Border border2 = new Border();
		Border border3 = new Border();
		Border border4 = new Border();
		Border border5 = new Border();
		Border border6 = new Border();
		Border border7 = new Border();
		Border border8 = new Border();
		Border border9 = new Border();
		
		addField(holeField);
		addField(stableIce1);
		addField(unstableIce2);
		addField(stableIce3);
		addField(stableIce4);
		addField(stableIce5);
		addField(stableIce6);
		addField(unstableIce);
		addField(border1);
		addField(border2);
		addField(border3);
		addField(border4);
		addField(border5);
		addField(border5);
		addField(border6);
		addField(border7);
		addField(border8);
		addField(border9);
		
		System.out.println("Creating and adding as many avatars as a proper test needs");
		Eskimo eskimo = new Eskimo();
		eskimo.gameEnder = gameEnder;
		Researcher researcher = new Researcher();
		researcher.gameEnder = gameEnder;
		Eskimo eskimo2 = new Eskimo();
		eskimo2.gameEnder = gameEnder;
		
		addAvatar(eskimo);
		addAvatar(eskimo2);
		addAvatar(researcher);
		
		System.out.println("Putting avatars on Fields");
		
		eskimo.field = stableIce3;
		eskimo2.field = unstableIce;
		researcher.field = stableIce4;
		stableIce3.addAvatar(eskimo);
		unstableIce.addAvatar(eskimo2);
		stableIce4.addAvatar(researcher);
		
		System.out.println("Setting up the neighbourhood");
		
		holeField.setNeighbour(border1);
		holeField.setNeighbour(unstableIce);
		holeField.setNeighbour(stableIce1);
		//Nincs nyugati szomszed, mert minek
		stableIce1.setNeighbour(border2);
		stableIce1.setNeighbour(stableIce3);
		stableIce1.setNeighbour(unstableIce2);
		stableIce1.setNeighbour(holeField);
		unstableIce2.setNeighbour(border3);
		unstableIce2.setNeighbour(stableIce4);
		unstableIce2.setNeighbour(border4);
		unstableIce2.setNeighbour(stableIce1);
		unstableIce.setNeighbour(holeField);
		unstableIce.setNeighbour(stableIce5);
		unstableIce.setNeighbour(stableIce3);
		//Nincs nyugati szomszed, mert minek
		stableIce3.setNeighbour(stableIce1);
		stableIce3.setNeighbour(stableIce6);
		stableIce3.setNeighbour(stableIce4);
		stableIce3.setNeighbour(unstableIce);
		stableIce4.setNeighbour(unstableIce2);
		stableIce4.setNeighbour(border6);
		stableIce4.setNeighbour(border5);
		stableIce4.setNeighbour(stableIce3);
		stableIce5.setNeighbour(unstableIce);
		stableIce5.setNeighbour(border7);
		stableIce5.setNeighbour(stableIce6);
		//Nincs nyugati szomszed, mert minek
		stableIce6.setNeighbour(stableIce3);
		stableIce6.setNeighbour(border8);
		stableIce6.setNeighbour(border6);
		stableIce6.setNeighbour(stableIce5);
		
		System.out.println("Creating and putting items on Fields");
		
		WetSuit wetSuit = new WetSuit();
		Flare flare = new Flare();
		Food food = new Food();
		Shovel shovel = new Shovel();
		Rope rope = new Rope();
		Cartridge cartridge = new Cartridge();
		Gun gun = new Gun();
		
		stableIce1.item = wetSuit;
		unstableIce2.item = flare;
		unstableIce.item = food;
		stableIce3.item = shovel;
		stableIce4.item = rope;
		stableIce5.item = cartridge;
		stableIce6.item = gun;
		
		System.out.println(">GameArea.constructor()");
	}
	
	/*
	 * Ez valt aktiv Avatart a tömbben
	 * Benedek
	 */
	public void changeActiveAvatar() {
		System.out.println("<GameArea.changeActiveAvatar()");
		
		System.out.println(">GameArea.changeActiveAvatar()");
	}
	
	private void addField(Field f) {
		System.out.println("<GameArea.addField()");
		fieldsOnArea.add(f);
		System.out.println(">GameArea.addField()");
	}
	
	void addAvatar(Avatar a) {
		System.out.println("<GameArea.addAvatar()");
		avatars.add(a);
		System.out.println(">GameArea.addAvatar()");
	}
}
