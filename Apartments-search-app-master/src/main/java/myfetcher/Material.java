package myfetcher;
import mycode.Home;
public class Material implements GeneralSpec {
	private String materialType;
	public Material(String material) {
		this.materialType = material.toUpperCase();
	}
	@Override
	public boolean isSpecMatch(Home i) {
		return i.getMaterial().equals(materialType);
	}
}