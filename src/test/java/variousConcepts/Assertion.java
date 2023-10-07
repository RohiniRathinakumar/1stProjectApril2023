package variousConcepts;

public class Assertion {
	public static void main(String[] args) {
		int age =25;
		assert age>=18:"Age should be 18 or older";
		
		String username=null;
		assert username!=null:"username should not be null";
		
		boolean isDatabaseConnected=false;
		assert isDatabaseConnected:"Database should be connected";
		
	}
	

}
////span[text()='Computers & Accessories']
/////li[@class='child-nav']/child::button
////a[text()='View All Monitors']