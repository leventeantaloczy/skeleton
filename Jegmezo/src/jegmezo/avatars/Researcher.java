package jegmezo.avatars;
import jegmezo.fields.*;
import jegmezo.Direction;

public class Researcher extends Avatar{

	public Researcher() {
		super(4); 
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * A d iranyu mezot leelenorzi és visszater annak kapacitas ertekevel
	 * Levente
	 */
	public int specialMove(Direction d) throws IOException {
		System.out.println("<Researcher.checkField()");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How much is the capacity of the neighbour? WRITE A NUMBER");
    		String command4 = br.readLine();
		
		System.out.println(">Researcher.checkField()");
		return Integer.parseInt(command4);
	}
	
}
