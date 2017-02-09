
public class AdvanceTicket extends Ticket {
	public AdvanceTicket(int number){
		//creates new ticket using extended code from ticket
		super(number);
	}
	
	public double getPrice(int days){
		//returns the price depending on the how many days before the
		//ticket was bought
		if(days >= 10){
			return 30.0;
		}else{
			return 40.0;
		}
	}
}
