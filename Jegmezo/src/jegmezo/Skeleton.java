package jegmezo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skeleton {

	public static void main(String[] args) {
		System.out.println("What should we test?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Init (Start Game): 1; Avatar move (Field accept, Add Avatar, Remove Avatar, Set Activity Points): 2;");
        System.out.println("Igloo building (Set Activity Points): 3; Check capacity (Set Activity Points): 4;");
        System.out.println("Avatar dies in water (EndGame): 5; Avatar dies because of heat loss (EndGame): 6");
        System.out.println("Backpacking and using an Item (Set Activity Points): 7 or a Snow Storm: 8 ?");
        String command = null;
		try {
			command = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controller c = new Controller(command);
    }
}
