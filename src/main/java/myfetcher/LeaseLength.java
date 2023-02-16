package myfetcher;
import mycode.Home;
public class LeaseLength implements GeneralSpec {
	private int  leaseLength0=0;
	public LeaseLength(String int1) {
		if (!int1.equals("-")) {
		this.leaseLength0 = Integer.parseInt(int1);
		}
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getLeaselength()==leaseLength0;
	}
}