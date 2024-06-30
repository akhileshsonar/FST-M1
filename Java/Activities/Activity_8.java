package my_activities;

public class Activity_8 {

	public static void main(String[] args) {
		
		try {
			Activity_8.exceptionTest("Testing My massage");
			
			Activity_8.exceptionTest("");
			Activity_8.exceptionTest("Test "+null);
			Activity_8.exceptionTest("Test "+"Massage");
			Activity_8.exceptionTest("Test "+"");
			Activity_8.exceptionTest(null);
		} catch (CustomException e) {
			
		System.out.println("Expection is "+e.getMessage());
		}
	}
	static void exceptionTest(String string) throws CustomException {
		if (string == null) {
			throw new CustomException("String value is null");
		} else {
			System.out.println("My String " + string);
		}

	}

}