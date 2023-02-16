package myfetcher;
import mycode.Home;
public class Bathrooms implements GeneralSpec{
	private int bathroomsNum=0;
	public Bathrooms(String int1) {
		if (!int1.equals("-")) {
		this.bathroomsNum = Integer.parseInt(int1);
		}
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getBathrooms()==bathroomsNum;
	}
}