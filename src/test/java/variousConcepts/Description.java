package variousConcepts;

import java.util.Scanner;
 
public class Description {

	public static String getInput1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your Description :");
		String str = sc.nextLine();
		return str;

	}

	public static int getInput2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Amount :");
		int amt = sc.nextInt();
		return amt;

	}

}
