package myfetcher;
import mycode.Home;
public class Type implements GeneralSpec {
	private String typeIs;
	public Type(String type) {
		this.typeIs = type.toUpperCase();
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getType().equals(typeIs);
	}
}