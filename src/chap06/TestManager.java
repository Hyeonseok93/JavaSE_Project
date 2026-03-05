package chap06;

public class TestManager {

	public static void main( String[] args ) {
	    Manager m = new Manager( "소지섭" , 50000.0, "기술교육팀" );
	    System.out.println( m.getDetails() );
 
        Manager m2 = new Manager();
        m2.setName("소지섭"); 
        System.out.println( m2.getDetails() ); 
    }
}
 
