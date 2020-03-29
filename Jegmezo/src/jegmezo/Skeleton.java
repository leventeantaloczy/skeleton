package jegmezo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import jegmezo.avatars.Eskimo;

public class Skeleton {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Program inditasa:");
		
		while(true) {
			System.out.println("Jatek inicializalas: 1");
			System.out.println("Avatar mozgatása: 2");
			System.out.println("Eskimo iglut epit: 3");
			System.out.println("Sarkkutato megnezi a szomszedos jegtablat: 4");
			
			switch(br.readLine()) {
			case("1"):{
				Controller controller = new Controller();
				controller.startGame();
			}
			case("2"):{
				GameEnder gameEnder = new GameEnder();
				GameArea gameArea = new GameArea(gameEnder);
				Eskimo eskimo = new Eskimo();
				gameArea.addAvatar(eskimo);
				
				
			}
			}
			
		}
	}

}
