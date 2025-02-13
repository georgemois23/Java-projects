package bb;

import java.util.ArrayList;

public class Airport {
	private String name;
	private String code;
	private String city;
	private String country;
	private ArrayList<String> airlines;

	
	
	public Airport(String name, String code, String city, String country) {
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
        this.airlines = new ArrayList<>();
    }

	
	//FIND THE DIRECTLY CONNECTIONS 
	public boolean isDirectlyConnectedTo(Airport anAirport) {
	    for (Flight flight : CentralRegistry.getFlights()) {
	        Airport a1 = flight.getAirportA();
	        Airport a2 = flight.getAirportB();

	        if ((name.equals(a1.getName()) || name.equals(a2.getName())) &&
	            (anAirport.equals(a1) || anAirport.equals(a2))) {
	            return true;
	        }
	    }
	    return false;
	}
	
	//FIND THE INDIRECTLY CONNECTIONS 
	public boolean isInDirectlyConnectedTo(Airport anAirport) {
	    for (Flight flight : CentralRegistry.getFlights()) {
	        Airport connectedAirport = null;

	        if (name.equals(flight.getAirportA().getName())) {
	            connectedAirport = flight.getAirportA();
	        } else if (name.equals(flight.getAirportB().getName())) {
	            connectedAirport = flight.getAirportB();
	        }

	        if (connectedAirport != null) {
	            for (Airport a : CentralRegistry.getAirports()) {
	                if (connectedAirport.isDirectlyConnectedTo(a) && a.isDirectlyConnectedTo(anAirport)) {
	                    return true;
	                }
	            }
	        }
	    }

	    return false;
	}
	
	//GET COMMON CONNECTIONS
	public ArrayList<Airport> getCommonConnections(Airport anAirport)
	{
		ArrayList<Airport> air1= new ArrayList<Airport>();
		ArrayList<Airport> air2= new ArrayList<Airport>();
	
		
		
		for (Flight flight : CentralRegistry.getFlights()) {
	        Airport a2 = flight.getAirportB();
	        Airport a1 = flight.getAirportA();
	       
	        if ((this.name.equals(a1.getName()) || this.name.equals(a2.getName())) &&
	            (this.equals(a1) || this.equals(a2))) {
	        	 if (!air1.contains(a1)) {
	                 air1.add(a1);
	             }

	             if (!air1.contains(a2)) {
	                 air1.add(a2);
	             }
	            
	        }
	        }
		
		for (Flight flight : CentralRegistry.getFlights()) {
	        Airport a2 = flight.getAirportB();
	        Airport a1 = flight.getAirportA();
	       
	        if ((anAirport.name.equals(a1.getName()) || anAirport.name.equals(a2.getName())) &&
	            (anAirport.equals(a1) || anAirport.equals(a2))) {
	        	 if (!air2.contains(a1)) {
	                 air2.add(a1);
	             }

	             if (!air2.contains(a2)) {
	                 air2.add(a2);
	             }
	            
	        }
	        }
		
		ArrayList<Airport> air3 = new ArrayList<>(air1); 
		air3.retainAll(air2); //INTERSECTION
		
		return air3;
		
	}
	
	//PRINT EACH COMPANIE
	public void printCompanies() {
		
		for(Flight flight:CentralRegistry.getFlights())
		{
			Airport a2 = flight.getAirportB();
	        Airport a1 = flight.getAirportA();

			
			if((this.equals(a1) || this.equals(a2)&&flight.airline != null))
			{
				this.airlines.add(flight.getAirline());
//				System.out.println(this.airlines);
			}
		}
		
		for(int i=0; i<airlines.size(); i++)
		{
			System.out.println(airlines.get(i)+" ");
		}

	};
	
	
	 //Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public ArrayList<String> getAirlines() {
		return airlines;
	}
	public void setAirlines(ArrayList<String> airlines ) {
		this.airlines.addAll(airlines);
	}
	
	
}
/*

import java.util.ArrayList;

public class Airport {
    String name;
    String code;
    String city;
    String country;
    ArrayList<Airport> connectedAirports;

    public Airport(String name, String code, String city, String country) {
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
        this.connectedAirports = new ArrayList<>();
    }
    
    public void addConnectedAirport(Airport airport) {
        if (!connectedAirports.contains(airport)) {
            connectedAirports.add(airport);
            airport.connectedAirports.add(this);  // Automatically add the connection in both directions
        }
    }
    public boolean isDirectlyConnectedTo(Airport anAirport) {
//        return this.name.equals(anAirport.name);
    	return connectedAirports.contains(anAirport);
    }
    
    public boolean isInDirectlyConnectedTo(Airport anAirport) {
        return connectedAirports.contains(anAirport);
    }

//    public void addConnectedAirport(Airport airport) {
//        connectedAirports.add(airport);
//    }

    public ArrayList<Airport> getConnectedAirports() {
        return connectedAirports;
    }

//    public boolean isDirectlyConnectedTo(Airport anAirport) {
//        return this.name.equals(anAirport.name);
//    }

    public void printdata() {
        System.out.println(name);
        System.out.println(code);
        System.out.println(city);
        System.out.println(country);
        System.out.println();
    }

    public void printConnectedAirports() {
        System.out.println("Connections for " + name + ":");
        for (Airport connectedAirport : connectedAirports) {
            System.out.println("  " + connectedAirport.getName());
        }
        System.out.println("----------");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
*/