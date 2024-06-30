package my_activities;

abstract class Activity_5_Abstract {

	String title;

	abstract void setTitle(String title);
	String getTitle() {
		return title;
	}

}

class Activity_5_Books extends Activity_5_Abstract {

	public void setTitle(String title_of_book) {
		title = title_of_book;
	}
}

class Activity_5_Project extends Activity_5_Abstract {

	public void setTitle(String title_of_book) {
		title = title_of_book;
	}
}

public class Activity_5 {

	public static void main(String[] args) {

		String Book_title = "Core Jave";
		Activity_5_Abstract A5_B = new Activity_5_Books();
		Activity_5_Abstract A5_P = new Activity_5_Books();
		A5_B.title = Book_title;
		System.out.println("Book title is -> " + A5_B.getTitle());
		String Project_title="Car Project";
		A5_P.title = Project_title;
		System.out.println("Book title is -> " + A5_P.getTitle());
	}

}
