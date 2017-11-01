
import java.util.ArrayList;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;



public class World {

	
	private static ArrayList places = new ArrayList<Place>();
	
	
	public World(String path) throws IOException {
		openFile(path) ;
	}
	
	public void filter() {
		for(int i = 0; i<places.size() ; i++) {
			Place p = (Place) places.get(i) ;
			for(int j = i+1; j<places.size(); j++) {
				Place p2 = (Place) places.get(j) ;
				if(p.returnlatitude() == p2.returnlatitude() && p.returnlongitude() == p2.returnlongitude()) {
					places.remove(j) ; 
					j-- ;
				}
			}
		}
	}

    public void openFile(String path) throws IOException {
        int i = 0 ;
    	
    	FileReader fr = new FileReader(path) ;
        BufferedReader textReader = new BufferedReader(fr) ;
        String line = "hello" ;
        line = textReader.readLine() ;
        while( line.equals("NODE_COORD_SECTION") != true ) {
        	line = textReader.readLine() ;
        }
        line = textReader.readLine() ;
        while( line.equals("EOF") != true ) {
        	String[] parts = line.split(" ");
        	int s = Integer.parseInt(parts[0]) ;
        	double x = Double.parseDouble(parts[1]) ;
        	double y = Double.parseDouble(parts[2]) ;
        	Place p = new Place(s, x, y ) ;
        	places.add(p) ;
  
         
          i++ ;
        //	System.out.println(parts[0]) ;
        //	System.out.println(parts[1]) ;
        //	System.out.println(parts[2]) ;
        	line = textReader.readLine() ;
        }
         
      
      }

    public ArrayList returnplaces() {
    	 return places ;
    }
    public static int numberofPlaces() {
    	return places.size();
    }
    public static Place getPlace(int index) {
    	 return (Place)places.get(index);
    	
    }
    
}