package CeckOut;
public class Prod {
	private  int price;
	private String name;
	public int count=0;
	Prod(String s,int price ){
		this.price=price;
		this.name=s;
	}
	public void setCount(int k) {
		count=k;
	}
	public void setName (String s) {
		this.name=s;
	}
	public void setPrice (int s) {
		this.price=s;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	} 
	public int getCount() {
		return this.count;
	}
	public void addOne() {
		count++;
	} 
}