package my_activities;

import java.util.Scanner;

class Bicycle implements BicycleParts, BicycleOperations {

	public int gears;
	public int currentSpeed;

	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}
	
	public void applyBrake(int decrement) {
		currentSpeed -= decrement;
		System.out.println("Current speed: " + currentSpeed);
	}

	public void speedUp(int increment) {
		currentSpeed += increment;
		System.out.println("Current speed: " + currentSpeed);
	}

	public String bicycleDesc() {
		return ("No of gears are " + gears + "\nSpeed of bicycle is " + currentSpeed);
	}
}

class MountainBike extends Bicycle {

	public int seatHeight;

	public MountainBike(int gears, int currentSpeed, int startHeight) {

		super(gears, currentSpeed);
		seatHeight = startHeight;
	}

	public void setHeight(int newValue) {
		seatHeight = newValue;
	}

	public String bicycleDesc() {
		return (super.bicycleDesc() + "\nSeat height is " + seatHeight);
	}
}
public class Activity_7 {

	
	public static void main(String[] args) {
		
		Scanner input =new Scanner(System.in);
		System.out.println("Enter grear ");
		System.out.println("Enter Speed ");
		System.out.println("Enter height ");
		 MountainBike mb = new MountainBike(input.nextInt(),input.nextInt(), input.nextInt());
	        System.out.println(mb.bicycleDesc());
	        mb.speedUp(20);
	        mb.applyBrake(5);

	}

}