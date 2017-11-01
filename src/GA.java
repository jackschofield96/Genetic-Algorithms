import java.io.IOException;

public class GA {

    
    private static double mutationRate = 0.015;
    private static int tournamentSize = 20;
    
    //create a new population, saving the best solution from the previous and using tournment selection crossover. 
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);
        newPopulation.saveIndividual(0, pop.getFittest());
        for (int i = 1; i < newPopulation.populationSize(); i++) {
            Individual parent1 = tournamentSelection(pop);
            Individual parent2 = tournamentSelection(pop);
            
            Individual child = crossover(parent1, parent2);
            
            newPopulation.saveIndividual(i, child);
        }

        for (int i = 1; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    //select subroutes within parent, fill the rest of the cities in.
    public static Individual crossover(Individual parent1, Individual parent2) {
        
        Individual child = new Individual();
        int startPlace = (int) (Math.random() * parent1.routeSize());
        int endPlace = (int) (Math.random() * parent1.routeSize());

         for (int i = 0; i < child.routeSize(); i++) {
            if (startPlace < endPlace && i > startPlace && i < endPlace) {
                child.addPlace(i, parent1.getPlace(i));
            } 
            else if (startPlace > endPlace) {
                if (!(i < startPlace && i > endPlace)) {
                    child.addPlace(i, parent1.getPlace(i));
                }
            }
        }

          for (int i = 0; i < parent2.routeSize(); i++) {
           if (!child.containsPlace(parent2.getPlace(i))) {
                for (int j = 0; j < child.routeSize(); j++) {
                      if (child.getPlace(j) == null) {
                      child.addPlace(j, parent2.getPlace(i));
                      break;
                    }
                }
            }
        }
        return child;
    }

    //Randomly swap two places locations within the route.
    private static void mutate(Individual route) {
        for(int i=0; i < route.routeSize(); i++){
            if(Math.random() < mutationRate){
                int tourPos2 = (int) (route.routeSize() * Math.random());
                Place city1 = route.getPlace(i);
                Place city2 = route.getPlace(tourPos2);
                route.addPlace(tourPos2, city1);
                route.addPlace(i, city2);
            }
        }
    }

    //tournement selection with tournement size 5
    private static Individual tournamentSelection(Population pop) {
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int j = (int) (Math.random() * pop.populationSize());
            tournament.saveIndividual(i, pop.getIndividual(j));
        }
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}