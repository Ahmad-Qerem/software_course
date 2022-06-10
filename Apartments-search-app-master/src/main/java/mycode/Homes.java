package mycode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import myfetcher.*;
public class Homes {
	private static EmailSender emailSender;
	private ArrayList<Home> homesGroup=new ArrayList<>();
	private String out="";
	private static final String EMAIL="khaledabulibdeh@gmail.com";
	private static final  String DASHS="+---+------------+------------+------------+------+-----------------------------------+-------+-------+----------+-----------+--------------+%n";
	public void addHouse(DataTable a) {
		Map <String,String> data = a.asMap(String.class,String.class);
		for	(String key:data.keySet()) {
			String[] info1=key.split("_");
			String[] info2=info1[4].split(",");
			String[] info3=data.get(key).split("_");
			Home h=new Home();
			h.setType(info1[0]);
			h.setMaterial(info1[1]);
			h.setPlacement(info1[2]);
			h.setPets(info1[3]);
			h.setAmenties(info2);
			h.setPrice(Integer.parseInt(info3[0]));
			h.setArea(Integer.parseInt(info3[1]));
			h.setBedrooms(Integer.parseInt(info3[2]));
			h.setBathrooms(Integer.parseInt(info3[3]));
			h.setLeaselength(Integer.parseInt(info3[4]));
			homesGroup.add(h);	
		}
	}
	public String getOut() {
		String o="";
		
		for (Home i : homesGroup) {
			String ma="";
			String[] m=i.getAmenties();
			
			for (int j=0;j<m.length;j++) {
				ma+=m[j]+",";
				}
			o+= i.getType()+" "+ i.getMaterial()+" "+i.getPlacement()+" "+i.getPets()+" "+ma+" "+i.getPrice()+" "+i.getArea()
			+" "+i.getBedrooms()+" "+i.getBathrooms()+" "+i.getLeaselength()+"\n";	   
		}
		return o;
	}
	public void setOut(String o) {
		out=o;
	}
	public void addHouse(Home home) {
		homesGroup.add(home);
	}
	public Boolean checkEmpity() {
		return homesGroup.isEmpty();
		}
	public void printHouse() {
		String leftAlignFormat = "| %-2d| %-10s | %-10s | %-10s | %-5s| %-33s |  %-5d|  %-5d|     %-5d|     %-5d |      %-6d  |%n";
		System.out.format(DASHS);
		System.out.format("| # | TYPE       | MATERIAL   | PLACEMENT  | PETS |            A M E N T I E          | PRICE |  AREA | BEDROOMS | BATHROOMS | LEASE LENGTH |%n");
		System.out.format(DASHS);
		int x=1;
		for (Home i:homesGroup) {
			String ma="";
			String[] m=i.getAmenties();
			for (int j=0;j<m.length;j++) {
				ma+=m[j]+",";
				}
		    System.out.format(leftAlignFormat,x,i.getType(),i.getMaterial(),i.getPlacement(),i.getPets(),ma,i.getPrice()
		    		,i.getArea(),i.getBedrooms(),i.getBathrooms(),i.getLeaselength());x++;
		}
		System.out.format(DASHS+"\n");
	}
	public boolean compareArrays(String [] arr1, String[] arr2) {
	    if (arr1.length != arr2.length) {
	        return false;
	    }
	    Arrays.sort(arr1);
	    Arrays.sort(arr2);
	    return Arrays.equals(arr1, arr2);
	}
	
	//Search fun
	public Homes searchByplace(boolean mock,String place) {
		GeneralSpec p=new Place(place);
		return searchBySpec(mock,place, p);
	}
	public Homes searchByMaterial(boolean mock,String material) {
		GeneralSpec m = new Material(material); 
		return searchBySpec(mock,material, m);
	}
	public Homes searchByBelowSpecificPrice(boolean mock,String pric) {
		GeneralSpec p=new Price(pric);
		return searchBySpec(mock,pric, p);
	}
	public Homes searchByPriceBetweenRange(boolean mock,Integer int1, Integer int2) {
		GeneralSpec pbr =new PriceBetweenRange(int1 ,int2);
		return isSpecTow(mock, pbr);
	}
	public Homes searchByAreaBetweenRange(boolean mock,Integer int1, Integer int2) {
		GeneralSpec br =new BetweenRange(int1 , int2);
		return isSpecTow(mock,br);
	}
	public Homes searchByBelowSpecificArea(boolean mock,String area) {
		GeneralSpec a=new Area(area);
		return searchBySpec(mock,area, a);
	}
	public Homes searchByNumberOfBedrooms(boolean mock,String int1) {
		GeneralSpec b=new Bedrooms(int1);
		return searchBySpec(mock,int1, b);
	}
	public Homes searchByNumberOfBathrooms(boolean mock,String int1) {
		GeneralSpec bt=new Bathrooms(int1);
		return searchBySpec(mock,int1, bt);
	}
	public Homes searchByAllowPets(boolean mock,String pets) {
		GeneralSpec p=new Pets (pets);
		return searchBySpec(mock,pets, p);
	}
	public Homes searchBytype(boolean mock,String type) {
		GeneralSpec t =new Type(type);
		return searchBySpec(mock,type, t);
	}
	public Homes searchByLeaseLength(boolean mock,String int1) {
		GeneralSpec ll =new LeaseLength(int1);
		return searchBySpec(mock,int1, ll);
	}
	public Homes searchByAmenties(boolean mock,String string) {
		if (string.equals("-"))
			return this;
		else {
		Homes result=new Homes();
		String[]arr1=string.split(",");
		for (int j =0;j<arr1.length;j++) {
			arr1[j]= arr1[j].toUpperCase();
		}
		for (Home i:homesGroup) {
			if (this.compareArrays(arr1,i.getAmenties())) {
				result.addHouse(i);
			}
		}
		out=result.getOut();
		if(mock) {
		emailSender.send(out,EMAIL);
		}
		return result;
		}
	}
	public Homes searchByComp(boolean mock,Homes hg,String...strings) {
		hg=hg.searchBytype(mock,strings[0]).searchByMaterial(mock, strings[1]).searchByplace(mock, strings[2]).searchByAllowPets(mock, strings[3]).searchByAmenties(mock, strings[4]).searchByBelowSpecificPrice(mock, strings[5])
		.searchByBelowSpecificArea(mock, strings[6]).searchByNumberOfBedrooms(mock, strings[7]).searchByNumberOfBathrooms(mock, strings[8]).searchByLeaseLength(mock, strings[9]);
		out=hg.getOut();
		emailSender.send(out,EMAIL);
		return hg;
	}
	
	public Homes isSpecTow(boolean mock,GeneralSpec pbr) {
		Homes result=new Homes();
		for (Home i:homesGroup) {
			if (pbr.isSpecMatch(i)) {
				result.addHouse(i);
			}
		}
		out=result.getOut();
		if(mock) {
		emailSender.send(out,EMAIL);
		}
		return result;
	}
	public Homes searchBySpec(boolean mock,String pric, GeneralSpec p) {
		if (pric.equals("-"))
			return this ;
		else {
		return isSpecTow(mock, p);
		}
	}

	//Check Fun 
	
	public Boolean checkResultPlace(String result) {
		GeneralSpec p=new Place(result);
		return checkSpesf(result, p);
	}
	public boolean checkResultMaterial(String result) {
		GeneralSpec m=new Material(result);
		return checkSpesf(result, m);
	}
	public boolean checkBelowSpecificPrice(String result) {
		GeneralSpec m=new Price(result);
		return checkSpesf(result, m);
	}
	public boolean checkBetweenSpecificPrice(int int1, int int2) {
		GeneralSpec pbr =new PriceBetweenRange(int1,int2);
		return checkBetweenRange(pbr);
	}
	public boolean checkBetweenSpecificArea(int int1, int int2) {
		GeneralSpec pbr =new BetweenRange(int1,int2);
		return checkBetweenRange(pbr);
	}
	public boolean checkBelowSpecificArea(String result) {
		GeneralSpec m=new Area(result);
		return checkSpesf(result, m);
	}
	public boolean checkNumberOfBedrooms(String result) {
		GeneralSpec m=new Bedrooms(result);
		return checkSpesf(result, m);
	}
	public boolean checkNumberOfBathrooms(String result) {
		GeneralSpec m=new Bathrooms(result);
		return checkSpesf(result, m);
	}
	public boolean checkAllowPets(String result) {
		GeneralSpec m=new Pets(result);
		return checkSpesf(result, m);
	}
	public boolean checkResultType(String result) {
		GeneralSpec m=new Type(result);
		return checkSpesf(result, m);
	}
	public boolean checkLeaseLength(String result) {
		GeneralSpec m=new LeaseLength(result);
		return checkSpesf(result, m);
	}
	public boolean checkAmenties(String result) {
		if (result.equals("-"))
			return true;
		else {
		String[]arr1=result.split(",");
		for (int j =0;j<arr1.length;j++) {
			arr1[j]= arr1[j].toUpperCase();
		}
		String[] arr2;
		
		for (Home i:homesGroup) {
			arr2=i.getAmenties();
			if (this.compareArrays(arr1, arr2)) {
				continue;
			}else {
				return false ;
			}
		}
		return true;	
		}
	}
	public boolean checkPyComp(String []result) {
		//(type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
		
		boolean b1=this.checkResultType(result[0]);
		boolean b2=this.checkResultMaterial(result[1]);
		boolean b3=this.checkResultPlace(result[2]);
		boolean b4=this.checkAllowPets(result[3]);
		boolean b5=this.checkAmenties(result[4]);
		boolean b6=this.checkBelowSpecificPrice(result[5]);
		boolean b7=this.checkBelowSpecificArea(result[6]);
		boolean b8=this.checkNumberOfBedrooms(result[7]);
		boolean b9=this.checkNumberOfBathrooms(result[8]);
		boolean b10=this.checkLeaseLength(result[9]);
		return (b1&&b2&&b3&&b4&&b5&&b6&&b7&&b8&&b9&&b10);
	}
	public boolean checkBetweenRange(GeneralSpec pbr) {
		for (Home i:homesGroup) {
			if (pbr.isSpecMatch(i))
				continue ;
			else {
				return false ;	
			}		
		}
		return true;
	}
	public boolean checkSpesf(String result, GeneralSpec m) {
		if (result.equals("-"))
			return true ;
		else {
		return checkBetweenRange(m);
		}
	}
	public static void setEmailService(EmailSender emailSender) {
		Homes.emailSender=emailSender;
	}
}
