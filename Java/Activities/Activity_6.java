package my_activities;

import java.util.Scanner;

public class Activity_6 {

	public static void main(String[] args) throws InterruptedException {
	
		Scanner input =new Scanner(System.in);
		System.out.println("How many passange");
		int count=input.nextInt();
		Activity_6_plane A6=new Activity_6_plane(count);
		System.out.println("Enter Passanger Name");
		for(int i=0;i<count;i++) {
			A6.onboard(input.nextLine());
		}
		System.out.println("Plane took off at: " + A6.takeOff());
        System.out.println("People on the plane: " + A6.getPassengers());
        Thread.sleep(5000);
        A6.land();
        System.out.println("Plane landed at: " + A6.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + A6.getPassengers());
	}

}
