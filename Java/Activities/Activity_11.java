package my_activities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Activity_11 {

	public static void main(String[] args) {
		Map<Integer,String> color =new HashMap<>();
		
		System.out.println("Enter 5 colors");
		Scanner input =new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			color.put(i, input.nextLine());
		}
		
		System.out.println("Afer adding elements "+color);
		
		if(color.containsValue("red")) {
			System.out.println("Exist "+color.containsValue("red"));
		}else {
			System.out.println("Not Exist "+color.containsValue("red"));
		}
		System.out.println("before elements size "+color.size());
		color.remove(2);
		System.out.println("final adding elements "+color);
		System.out.println("after elements size "+color.size());
	}

}
