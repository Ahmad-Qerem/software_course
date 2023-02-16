package myfetcher;
import mycode.Home;
public class Pets implements GeneralSpec {
	private String petsAllowed;
	public Pets(String pets) {
		this.petsAllowed = pets.toUpperCase();
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getPets().equals(petsAllowed);
	}
}