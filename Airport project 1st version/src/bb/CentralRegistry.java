package bb;

import java.util.ArrayList;


public class CentralRegistry {
    private static ArrayList<Airport> airports = new ArrayList<>();
    private static ArrayList<Flight> flights = new ArrayList<>();

    //add airport
    public static void addAirport(Airport airport) {
        airports.add(airport);
    }

    //add flight
    public static void addFlight(Flight flight) {
        flights.add(flight);
    }
    

    //getters and setters
    public static ArrayList<Airport> getAirports() {
        return airports;
    }

    public static ArrayList<Flight> getFlights() {
        return flights;
    }
    
    //get the flight with the biggest duration 
    public static Flight  getLongestFlight() {
    	int max=-1;
    	Flight maxflight=null;
    	for(Flight f: flights)
    	{
    		if(f.duration>max) {
    			max=f.duration;
    			maxflight=f;
    		}
    	}
    	return maxflight;
    }
    
    //get the airport with the most direct flights with other airports
    public static Airport getLargestHub() {
    	int max=-1;
    	Airport air=null;
    	int maxcount=-1;
    
    	for(Airport a:airports)
    	{
    		int count=0;
    		String namee=a.getName();
    		for (Flight flight : CentralRegistry.getFlights()) {
    	        Airport a2 = flight.getAirportB();
    	        Airport a1 = flight.getAirportA();
    	       
    	        if ((namee.equals(a1.getName()) || namee.equals(a2.getName())) &&
    	            (a.equals(a1) || a.equals(a2))) {
    	            count++;
    	            
    	        }
    	        
    	    }
    		if(count>maxcount) 
	        {
	        	maxcount=count;
	        	air=a;
	        }
    	}
    	return air;
    }
}

