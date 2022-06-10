package myfetcher;
import mycode.Home;
public class Area implements GeneralSpec{
	private int areaval=0;
	public Area(String area) {
		if (!area.equals("-")) {
		this.areaval =Integer.parseInt(area);
		}
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getArea()<= areaval;
	}
}