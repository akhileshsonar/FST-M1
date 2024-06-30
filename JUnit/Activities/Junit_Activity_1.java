package my_test_pack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
public class Junit_Activity_1 {
	
	
	  static ArrayList<String> list;
	  
	   
	    @BeforeEach
	    void setUp() throws Exception {
	        list = new ArrayList<String>();
	        list.add("A");
	        list.add("B");
	    }
	    @Order(1)
	    @Test
	    public void insertTest() {
	        assertEquals(2, list.size(), "OK insert");
	        list.add(2, "C");
	        System.out.println("insert "+list);
	        assertEquals(3, list.size());
	        assertEquals("A", list.get(0));
	    }
	    @Test
	    public void replaceTest() {
	        list.set(1, "C");
	        System.out.println("replace "+list);
	        assertEquals(2, list.size(), "OK replace");      
	        assertEquals("A", list.get(0));
	        assertEquals("C", list.get(1));
	    }

}
