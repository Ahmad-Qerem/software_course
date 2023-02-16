package mycode;
public class Home {
	private String  type;
	private String  material;
	private String  placement;
	private String pets;
	private String [] amenties;
	private int  price ;
	private int area;
	private int bedrooms ;
	private int bathrooms;
	private int leaselength;
	//constrector
	Home(){
		type=null;
		material=null;
		placement=null;
		pets=null;
		amenties = new String [6];
		price=0;
		area=0;
		bedrooms=0;
		bathrooms=0;
		leaselength=0;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public String getPets() {
		return pets;
	}
	public void setPets(String pets) {
		this.pets = pets;
	}
	public String[] getAmenties() {
		return amenties;
	}
	public void setAmenties(String[] amenties) {
		this.amenties = amenties;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getLeaselength() {
		return leaselength;
	}
	public void setLeaselength(int leaselength) {
		this.leaselength = leaselength;
	}
}