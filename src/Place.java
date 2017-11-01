public class Place {
    //Holds the number, and latitude longitude values taken from the .TSP file.
	int num ;
	double latitude ;
	double longitude ;
	
	
	public Place(int num, double latitude, double longitude) {
		this.num = num ;
		this.latitude= latitude ;
		this.longitude = longitude ;
	}


	public int returnnum() {
		return num ;
	}
	public double returnlatitude(){
		return latitude ;
	}
	public double returnlongitude(){
		return longitude ;
	}
	
	
	public double distanceTo(Place p) {
		double d = DistanceCalculator.distance(this.latitude,this.longitude,p.returnlatitude(), p.returnlongitude(), "K") ;
        return d ;	
 	}
	
	@Override
    public String toString(){
        String s = Integer.toString(num) ;
		return s ;
    }
	
}
