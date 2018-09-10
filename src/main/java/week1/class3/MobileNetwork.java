package week1.class3;

import java.util.Scanner;

public class MobileNetwork {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		if(input==944) {
			System.out.println("BSNL");
		}
		else if (input==900) {
			System.out.println("Airtel");
			
		}
		else if(input==897) {
			System.out.println("Idea");
		}
		else if (input==630) {
			System.out.println("Jio");
		}
			else
			{
				System.out.println("Unknown");
			
		}
		sc.close();
		

	}

}
