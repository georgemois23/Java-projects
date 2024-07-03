package bb;

public class Flight {
	Airport a1;
	Airport a2;
	Integer duration;
	String airline;
	
	
	//constructor of flight
	public Flight(Airport arrival,Airport departure,Integer duration,String airline) {
		this.a1=arrival;
		this.a2=departure;
		this.duration=duration;
		this.airline=airline;
	}
	public String toString() {
		return "Flight operated by "+airline+", duration "+duration+ " minutes\n";
	}

	// getters and setters
	public Airport getAirportA() {
		return a1;
	}

	public void setArrival(Airport arrival) {
		this.a1 = arrival;
	}

	public  Airport getAirportB() {
		return a2;
	}

	public void setDeparture(Airport departure) {
		this.a2 = departure;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	
	
	
}
