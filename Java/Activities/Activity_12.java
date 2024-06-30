package my_activities;

public class Activity_12 {

	public static void main(String[] args) {
    Addable adb =(a,b)->(a+b);
    System.out.println(adb.add(50,50));
    Addable adb2=(int a, int b)->{
    	return(a+b);
    };
    System.out.println(adb2.add(2, 100));
}

}