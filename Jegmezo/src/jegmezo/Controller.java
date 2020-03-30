package jegmezo;
import jegmezo.avatars.*;
import jegmezo.fields.*;
import jegmezo.items.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Controller {
	
	public static void startGame() throws IOException {
		System.out.println("<Controller.startGame()");
		
		GameEnder gameEnder = new GameEnder();
		GameArea gameArea = new GameArea(gameEnder);
		runGame(gameEnder, gameArea);
		
		System.out.println(">Controller.startGame()");
	}
	
	/*
	 * Itt fog futni a jatek
	 */
	public static void runGame(GameEnder gameEnder, GameArea gameArea) throws IOException {
		System.out.println("<Controller.runGame()");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = br.readLine();
		switch(command) {
		case "1":
		    //Ez mindenképp kell, úgyhogy mire ideérünk már le is futott
		    break;
		case "2":
		    // code
		    break;
		case "3":
		    // code
		    break;
		case "4":
		    // code
		    break;
		case "5":
		    // code
		    break;
		case "6":
		    // code
		    break;
		case "7":
		    // code
		    break;
		case "8":
		    Storm(gameArea.fieldsOnArea);
		    break;
		}
		
		System.out.println(">Controller.runGame()");
	}
	
	/*
	 * Kap egy csomag mezot, amiket behavaz.
	 * Zoli
	 */
	public static void Storm(List<Field> fields) {
		System.out.println("<Controller.Storm()");
		
		for(int i = 0; i < fields.size(); i++) {
			System.out.println("Havazzon ezen a mezon? Y/N");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String command = br.readLine();
			if(command.toUpperCase().equalsIgnoreCase("Y"))
				fields.get(i).setSnow(1);
			System.out.println("Van ezen a mezon iglu? Y/N");
			String command2 = br.readLine();
			if(command2.toUpperCase().equalsIgnoreCase("Y"))
				fields.get(i).setIgloo();
			System.out.println("All ezen a mezon Avatar? Y/N");
			String command3 = br.readLine();
			if(command3.toUpperCase().equalsIgnoreCase("Y")) {
				if(command2.toUpperCase().equalsIgnoreCase("N")) {
					Eskimo e = new Eskimo();
					e.loseHealth();	
				}
			}
	        }
		
		System.out.println(">Controller.Storm()");
	}
	
	
    
     public static void main(String[] args) {
     System.out.println("A legjobb targy a Projlab!! -help ;)");
     System.out.println("What should we test?");
     System.out.println("Init (Start Game): 1; Avatar move (Field accept, Add Avatar, Remove Avatar, Set Activity Points): 2;");
     System.out.println("Igloo building (Set Activity Points): 3; Check capacity (Set Activity Points): 4;");
     System.out.println("Avatar dies in water (EndGame): 5; Avatar dies because of heat loss (EndGame): 6");
     System.out.println("Useage of an Item (Set Activity Points): 7 or a Snow Storm: 8 ?");  
        
     try {
		startGame();
	} catch (IOException e) {
		System.out.println("IOexception: startgame");
		e.printStackTrace();
	}
}
