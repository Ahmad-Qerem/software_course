package myfetcher;
import mycode.Home;
public class Price implements GeneralSpec {
	private int pric=0;
	public Price(String pric) {
		if (!pric.equals("-")) {
		this.pric = Integer.parseInt(pric);
		}
		}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getPrice()<= pric;
	}
}