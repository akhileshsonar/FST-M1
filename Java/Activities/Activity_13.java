package my_activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity_13 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();
        System.out.println("how many integer value you want");
        int limit=scan.nextInt();
        int i=0;
        System.out.println("Enter integers please ");
        while(i<limit) {
            list.add(scan.nextInt());
            i++;
        }
        Integer nums[] = list.toArray(new Integer[1]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);
 
        scan.close();
	}

}
