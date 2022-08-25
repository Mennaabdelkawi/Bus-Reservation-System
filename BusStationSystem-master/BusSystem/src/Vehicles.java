
public class Vehicles {
	
	String vehicleType;
	int numberOfSeats;
	
	public Vehicles(String nameType,int numberOfSeats) {
		
		this.vehicleType = nameType;
		this.numberOfSeats = numberOfSeats;
	}
	// NuLL constructor
	
	public Vehicles() {
		
	}
	
	public void setSeats(int noSeats) {
		this.numberOfSeats = noSeats; 
	}
	
	public String vehicleType() {
		return vehicleType;
	}
	
	public int checkNumberOfSeats() {
		return numberOfSeats;
	}
	
	public int reserveSeat() {
		return numberOfSeats--;
	}
	
	public int restoreSeat() {         //When canceling a trip
		return numberOfSeats++;
	}
	
}
