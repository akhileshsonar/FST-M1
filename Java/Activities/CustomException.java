package my_activities;

public class CustomException extends Exception {
	
	private String massage=null;
	
	public  CustomException(String massage) {
		this.massage=massage;
	}
	@Override
    public String getMessage() {
        return massage;
    }
}
