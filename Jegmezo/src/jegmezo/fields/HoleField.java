package jegmezo.fields;

public class HoleField extends Field{
	public boolean addAvatar(Avatar a) {
		System.out.println("<Field.addAvatar()");
		avatars.add(a);
		System.out.println(">Field.addAvatar()");
		return true;
	}
}
