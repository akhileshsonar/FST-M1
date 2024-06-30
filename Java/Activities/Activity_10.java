package my_activities;

import java.util.HashSet;
import java.util.Set;

public class Activity_10 {

	public static void main(String[] args) {
		 Set<String> Month = new HashSet<String>();

		 	Month.add("Jan");
	        Month.add("Feb");
	        Month.add("MAR");
	        
	       
	        System.out.println("Original Set: " + Month);       
	        System.out.println("Size of set: " + Month.size());
	        
	        System.out.println("Check element Removed ");
	        
	        
	        if(Month.remove("MAR")) {
	        	System.out.println("Removed");
	        } else {
	        	System.out.println("Not exist");
	        }
	        
	        System.out.println("Check element Exist or not");
	        if(Month.contains("Jan")) {
	        	System.out.println("Present");
	        } else {
	        	System.out.println("Not Present");
	        }
	        
	        System.out.println("Check element is present or not: " + Month.contains("Feb"));
	        System.out.println("Final Set element: " + Month);
	        System.out.println("Final Size of set: " + Month.size());
	}

}
