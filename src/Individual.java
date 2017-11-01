import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;


//individual solution
public class Individual {
    private ArrayList<Place> route = new ArrayList<Place>();
    private double fitness = 0;
    private int distance = 0;
    
    //initialise empty solution
    public Individual(){
        for (int i = 0; i < World.numberofPlaces(); i++) {
            route.add(null);
        }
    }
    
    //initialise with route
    public Individual(ArrayList route){
        this.route = route;
    }

    //randomly generate individual
    public void generateIndividual() {
        
        for (int placeIndex = 0; placeIndex < World.numberofPlaces(); placeIndex++) {
          addPlace(placeIndex, World.getPlace(placeIndex));
        }
        
        Collections.shuffle(route);
    }

    public Place getPlace(int routePosition) {
        return (Place)route.get(routePosition);
    }

    public void addPlace(int routePosition, Place place) {
        route.set(routePosition, place);
        fitness = 0;
        distance = 0;
    }
    
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    
    public int getDistance(){
        if (distance == 0) {
            int routeDistance = 0;
            for (int placeIndex=0; placeIndex < routeSize(); placeIndex++) {
                Place start = getPlace(placeIndex);
                Place destination;
                if(placeIndex+1 < routeSize()){
                    destination = getPlace(placeIndex+1);
                }
                else{
                    destination = getPlace(0);
                }
               routeDistance += start.distanceTo(destination);
            }
            distance = routeDistance;
       }
        return distance;
    }

  
    public int routeSize() {
        return route.size();
    }
    
    
    public boolean containsPlace(Place place){
        return route.contains(place);
    }
    
    @Override
    public String toString() {
        String Individual = "-";
        
        for (int i = 0; i < routeSize(); i++) {
            Individual += getPlace(i)+"-";
            
        }
        Individual += "END. Size: "+Integer.toString(routeSize()) ;
        return Individual;
    }
   
}