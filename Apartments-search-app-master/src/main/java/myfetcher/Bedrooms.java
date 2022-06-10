package myfetcher;
import mycode.Home;
public class Bedrooms implements GeneralSpec {
	private int int1=0;
	public Bedrooms(String int1) {
		if (!int1.equals("-")) {
		this.int1 = Integer.parseInt(int1);
		}
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getBedrooms()==int1;
	}
}
