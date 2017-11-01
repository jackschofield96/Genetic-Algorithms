import java.io.IOException;
import java.util.ArrayList;

public class TestSuite {

	public static void main(String[] args) throws IOException {
	    int[] results = new int[40] ;
	    int j = 0 ;
	     System.out.println("Start:");
	   /* for(int i = 100 ; i<2000 ; i+=200) {
	    	System.out.println("Step: "+ i);
	    	results[j] = RunGA.runGA(150,i) ;
	    	j+=1 ;
	    	
	    } */
	  
      /* for(int k =0 ; k< results.length ;k++) {
    	  System.out.println(results[k]);
      }  */
	     results[0] = RunGA.runGA(200, 100) ;
 
	}

}
