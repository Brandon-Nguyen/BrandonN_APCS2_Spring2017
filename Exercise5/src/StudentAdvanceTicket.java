
public class StudentAdvanceTicket extends AdvanceTicket {
	public StudentAdvanceTicket(int number){
		// creates a ticket and gives a number using the preexisting code
		super(number);
	}
	
	public double getPrice(int days){
		// returns the price of a ticket based on the days before the event
		// that the ticket was bought
		if(days >= 10){
			return 15.0;
		}else{
			return 20.0;
		}
	}
}
