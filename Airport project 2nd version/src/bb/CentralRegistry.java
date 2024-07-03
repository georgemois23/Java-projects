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
    
   public Airport getAirport(String cityName) {
	   for(Airport a:airports)
	   {
		   if (a.getCity()==cityName) return a;
	   }
	return null;
}
   
   public static String getDirectFlightsDetails(Airport a, Airport b) {
	   ArrayList<String> neww= new ArrayList();
	   int count=0;
	   for(Flight f:flights)
	   {
		   Airport a2 = f.getAirportB();
	       Airport a1 = f.getAirportA();
	       if ((a1.getName().equals(a.getName()) || a1.getName().equals(b.getName())) && 
	    		    (a2.getName().equals(a.getName()) || a2.getName().equals(b.getName()))) {
			   count++;
			   neww.add("["+count+"]"+f.toString());}
	   }
	   int length=neww.size();
	   if(length!=0) {
		   return String.join("", neww);}
	   return null;
}
   public static String getInDirectFlightsDetails(Airport a, Airport b) {
	   ArrayList<String> neww= new ArrayList();
	   int count=0;
	   
	   for (Flight flight : flights) {
	        Airport intermediateAirport = null;

	        if (a.equals(flight.getAirportA())) {
	            intermediateAirport = flight.getAirportB();
	        } else if (a.equals(flight.getAirportB())) {
	            intermediateAirport = flight.getAirportA();
	        }

	        if (intermediateAirport != null && !intermediateAirport.equals(b)) {
	            // Check if the intermediate airport is not the destination airport
	            for (Flight indirectFlight : flights) {
	                if (intermediateAirport.equals(indirectFlight.getAirportA()) &&
	                    b.equals(indirectFlight.getAirportB())) {
	                	count++;
	                	neww.add("["+count+"]"+intermediateAirport.getCity()+", "+intermediateAirport.getCode()+"\n");}
	                	
	                }}}
	            int length=neww.size();
	     	   if(length!=0) {
	     		   return String.join("", neww);}
	   return null;
	   }
   public static void name() {
	for(Airport a:airports)System.out.println(a.getAirlines());
}
   
   public static Airport CityAirport(String cityname) {
	   for (Airport a:airports)
	   {
		   if(a.getCity().equals(cityname)) return a;
	   }
	   return null;
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

