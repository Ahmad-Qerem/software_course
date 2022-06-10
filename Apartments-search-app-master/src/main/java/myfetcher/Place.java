package myfetcher;
import mycode.Home;
public class Place implements GeneralSpec {
	private String placeIs;
	public Place(String place) {
		this.placeIs = place.toUpperCase();
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getPlacement().equals(placeIs);
	}
}