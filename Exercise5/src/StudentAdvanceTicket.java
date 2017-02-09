// Brandon Nguyen, 2/8/17 2nd Period
public class StudentAdvanceTicket extends AdvanceTicket {
	public StudentAdvanceTicket(int number,int days){
		// creates a ticket and gives a number using the prexisting code
		super(number, days);
	}
	
	public double getPrice(){
		// returns the price of a ticket based on the days before the event
		// that the ticket was bought
		return (super.getPrice() / 2);
	}
}
