package my_activities;

import java.util.ArrayList;

public class Activity_9 {

	public static void main(String[] args) {
		
		
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");
       
        System.out.println("Before adding "+myList);
       
        myList.add(3, "Grapes");
        myList.add(1, "Papaya");
        
        System.out.println("Print All the Objects After adding:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("Get 3rd element " + myList.get(2));
        System.out.println("Check element " + myList.contains("Apple"));
        System.out.println("Check element " + myList.contains("Test"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Apple");
        System.out.println("After remove element: " + myList.size());
        
        System.out.println("Check element " + myList.contains("Apple"));
		
        System.out.println("final list "+myList);
	}

}
