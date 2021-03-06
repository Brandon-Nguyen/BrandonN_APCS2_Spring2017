// Brandon Nguyen, 2/8/17 2nd Period
abstract class Ticket {
	private int number;
	public Ticket(int number){
		// creates an instance of ticket and gives the corresponding
		// number to the corresponding ticket
		this.number = number;
	}
	public double getPrice(){
		// this thicket has no price value as of this moment and will
		// be overridden later on to set prices
		 return 0.0;
	 }
	public String toString(){
		// Prints out the ticket number as well as the price of the ticket
		 return("Number: " + this.number + ", Price: " + this.getPrice());
	 }
}
