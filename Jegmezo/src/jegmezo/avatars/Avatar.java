package jegmezo.avatars;
import jegmezo.fields.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.GameEnder;
import jegmezo.items.*;

public abstract class Avatar {
	
	public Field field;
	private List<Item> backpack;
	public boolean wearsWetsuit = false;
	public GameEnder gameEnder;
	public boolean EndTurn = false;
	
	
	/*
	 * mindenkinek 4 activityPoints-a van, bár ez állítható
	 * Levente
	 */
	
	public Avatar(int hp) {	
		backpack = new LinkedList<Item>();
	}
	
	/*
	 * a backpack lancolt lista vegere fuzi az itemet
	 * Levente
	 */
	
	public void addToBackpack(Item i) {
		System.out.println("<Avatar.addToBackpack()");
		backpack.add(i);
		System.out.println(">Avatar.addToBackpack()");
	}
	
	/*
	 * használja az adott itemet
	 * Levente
	 */
	public void useItem(Item i) {
		System.out.println("<Avatar.useItem()");
		i.use(this);
		this.setActivity(1);
		System.out.println(">Avatar.useItem()");
	}
	
	/*
	 * TODO
	 * Meg kell hívni a gameEnder endGame()-jét de nem tudom, azt látja-e
	 * Várni kell majd előbb egy kört
	 */
	public void dieByWater() {
		System.out.println("<Avatar.dieByWater()");
		if(!wearsWetsuit)
			gameEnder.endGame();
		System.out.println(">Avatar.dieByWater()");
	}
	
	/*
	* Kihűl, elhalálozik
	* Zoli
	*/
	public void dieByHeatLoss() {
		System.out.println("<Avatar.dieByHeatLoss()");
		gameEnder.endGame();
		System.out.println(">Avatar.dieByHeatLoss()");
	}
	
	/*
	 * Eletero novekszik etel hatiasara
	 * Levente 
	 */
	public void gainHealth() {
		System.out.println("<Avatar.gainHealth()");
		System.out.println(">Avatar.gainHealth()");
	}
	
	/*
	 * hp vesztes, ha 0 meghal heatLoss-ban
	 * Levente
	 */
	public void loseHealth() throws IOException {
		System.out.println("<Avatar.loseHealth()");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Will the poor guy die, because of this? Y/N");
    	String command4 = br.readLine();
    	if(command4.toUpperCase().equalsIgnoreCase("Y")) {
    		this.dieByHeatLoss();
    	}
		System.out.println(">Avatar.loseHealth()");
	}
	
	/*
	 * getter
	 * Levente
	 */
	public Field getField() {
		System.out.println("<Avatar.getField()");
		System.out.println(">Avatar.getField()");
		return field;
	}
	
	/*
	 * d irányba elmozdul ha tud (csak akkor nem tud ha határmező van ott) 
	 * Levente
	 */
	public void move(Direction d) throws IOException {
		System.out.println("<Avatar.move()");
		Field f = field.getNeighbour(d);
		
		if(f.accept()) {
			if(false == f.addAvatar(this));
				gameEnder.endGame();
			field.removeAvatar(this);
			this.setActivity(1);
		}
		
		System.out.println(">Avatar.move()");
	}
	
	/*
	 *
	 */
	public void endTurn() {
		System.out.println("<Avatar.endTurn()");
		this.EndTurn  = true;
		System.out.println(">Avatar.endTurn()");
	}
	
	/*
	 *  Az activityPoints atributumhoz hozzadja (levonja)
	 * azt amennyi kell a munka végrehajtásához.
	 * Ha kifogy, meghívódik az endTurn()	
	 * Levente															
	 */
	public void setActivity(int i) {
		System.out.println("<Avatar.setActivity()");
		System.out.println(">Avatar.setActivity()");
	}
	
	public abstract int specialMove(Direction d) throws IOException ;
	
}
