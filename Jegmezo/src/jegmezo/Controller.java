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
	
	public static void startGame(String command) throws IOException {
		System.out.println("<Controller.startGame()");
		
		GameEnder gameEnder = new GameEnder();
		GameArea gameArea = new GameArea(gameEnder);
		runGame(gameEnder, gameArea, command);
		
		System.out.println(">Controller.startGame()");
	}
	
	
	/*
	 * Itt fog futni a jatek
	 */
	public static void runGame(GameEnder gameEnder, GameArea gameArea, String command) throws IOException {
		System.out.println("<Controller.runGame()");
		
        switch(command) {
        case "1":
        	System.out.println("This is necessary for every other case as well, so by the time you are reading this, Init has already run");
            break;
        case "2":
            gameArea.avatars.get(gameArea.activeAvatar).move(Direction.East);
            break;
        case "3":
        	gameArea.avatars.get(gameArea.activeAvatar).specialMove(Direction.North);
            break;
        case "4":
        	gameArea.activeAvatar++;
        	gameArea.avatars.get(gameArea.activeAvatar).specialMove(Direction.North);
            break;
        case "5":
        	gameArea.avatars.get(gameArea.activeAvatar).dieByWater();;
            break;
        case "6":
        	gameArea.avatars.get(gameArea.activeAvatar).dieByHeatLoss();
            break;
        case "7":
        	gameArea.activeAvatar++;
        	System.out.println("Which Item? Cartridge: C/ Flare: FL/Food: FO/ Gun: G/ Rope: R/ Shovel: S/ Wet Suit: W");
        	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String command1 = br1.readLine();
            switch(command1.toUpperCase()) {
            case "C":
            	Cartridge c = new Cartridge();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(c);
            	c.use(gameArea.avatars.get(gameArea.activeAvatar));
            	break;
            case "FL":
            	Flare fl = new Flare();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(fl);
            	fl.use(gameArea.avatars.get(gameArea.activeAvatar));
                break;
            case "FO":
            	Food fo = new Food();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(fo);
            	fo.use(gameArea.avatars.get(gameArea.activeAvatar));
                break;
            case "G":
            	Gun g = new Gun();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(g);
            	g.use(gameArea.avatars.get(gameArea.activeAvatar));
                break;
            case "R":
            	Rope r = new Rope();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(r);
            	r.use(gameArea.avatars.get(gameArea.activeAvatar));
                break;
            case "S":
            	Shovel s = new Shovel();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(s);
            	s.use(gameArea.avatars.get(gameArea.activeAvatar));
                break;
            case "W":
            	WetSuit w = new WetSuit();
            	gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(w);
            	w.use(gameArea.avatars.get(gameArea.activeAvatar));
                break;
            default:
            	System.out.println("Wrong input");
            	break;
            }
            break;
        case "8":
            Storm(gameArea.fieldsOnArea);
            break;
        default:
        	System.out.println("Wrong input");
        	break;
        }
        
        System.out.println(">Controller.runGame()");
	}
	
	/*
	 * Kap egy csomag mezot, amiket behavaz.
	 * Zoli
	 */
	public static void Storm(List<Field> fields) throws IOException {
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
	
	public Controller(String command) {
        System.out.println("A legjobb targy a Projlab!! -help ;)");
        
        try {
			startGame(command);
		} catch (IOException e) {
			System.out.println("IOexception: startgame");
			e.printStackTrace();
		}
    }  
}
