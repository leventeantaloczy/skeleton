package jegmezo.items;

import jegmezo.avatars.Avatar;

public class Cartridge extends Item{

	@Override
	public void use(Avatar a) {
		System.out.println("<Gun.use()");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ezen a fielden áll a többi alkatrész birtokosa is? Y/N");
		String answer = null;
    	try {
			answer = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(answer.toUpperCase() == "Y")
    		a.gameEnder.endGame();
		System.out.println(">Gun.use()");
		
	}

}
