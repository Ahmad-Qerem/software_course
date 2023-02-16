package myfetcher;
import mycode.Home;
public class BetweenRange implements GeneralSpec {
	private Integer int1=0;
	private Integer int2=0;
	public BetweenRange(Integer int1, Integer int2) {
		this.int1 = int1;
		this.int2 = int2;
	}
	@Override
	public boolean isSpecMatch(Home i) {
		
		return (i.getArea()<int2)&&(i.getArea()>int1);
	}
}