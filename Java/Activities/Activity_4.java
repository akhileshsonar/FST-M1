package my_activities;

import java.util.Arrays;

public class Activity_4 {
	
	static void ascendingSort(int data[]) {
		
		int size=data.length, i;
		
		for (i=0;i<size;i++) {
			int k=data[i];
			int j=i-1;
			System.out.println(k+" "+j);
			while (j >= 0 && k < data[j]) {
				data[j + 1] = data[j];
                --j;
            }
			data[j+1]=k;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		  int[] data = { 9, 5, 1, 4, 3 };
	        ascendingSort(data);
	        System.out.println("Sorted Array in Ascending Order: ");
	        System.out.println(Arrays.toString(data));
	}

}
