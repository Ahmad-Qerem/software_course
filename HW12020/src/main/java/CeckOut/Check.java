package CeckOut;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Check {
	ArrayList <Prod> a =new ArrayList();
	public void addProd(String s,int price ) {
		Prod P=new Prod(s,price);
		a.add(P);
	} 
	public void setCount(int x,String s) {
		
		for (int i=0;i<a.size();i++) {
			if (s.equals(a.get(i).getName())) {
				if (a.get(i).getCount()==0)
				a.get(i).setCount(x);
				else {
					a.get(i).addOne();
				}		
			}
		}	
	}
	public int findTotal() {
		int sum=0;
		for (int i=0;i<a.size();i++) {
			sum+=a.get(i).getPrice()*a.get(i).getCount();
		}
		return sum;
	}
	public void clearList() {
		a.clear();	
	}
}
