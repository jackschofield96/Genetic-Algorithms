import java.io.IOException;
import java.util.ArrayList;

public class RunGA {

	public static int runGA(int popsize, int evolvenum) throws IOException {
		World w = new World("places.txt") ;
		w.filter();
		Population pop = new Population(popsize, true);
	    // System.out.println("Initial distance: " + pop.getFittest().getDistance());
	     pop = GA.evolvePopulation(pop);
	     for (int i = 0; i < evolvenum; i++) {
	         pop = GA.evolvePopulation(pop);
	         System.out.println(pop.getFittest().getDistance());
	     } 
	     return pop.getFittest().getDistance() ;

	     // Print final results
	     //System.out.println("Finished");
	     //System.out.println("Final distance: " + pop.getFittest().getDistance());
	     //System.out.println("Solution:");
	     //System.out.println(pop.getFittest()); 
		
         
        
      
		 
	}
}