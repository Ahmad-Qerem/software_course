package myfetcher;

import mycode.Home;

public class PriceBetweenRange implements GeneralSpec {

	private Integer int1=0;
	private Integer int2=0;

	public PriceBetweenRange(Integer int1, Integer int2) {
		this.int1 = int1;
		this.int2 = int2;
	}

	@Override
	public boolean isSpecMatch(Home i) {

		return i.getPrice()<int1&&i.getPrice()>int2;
	}

}
