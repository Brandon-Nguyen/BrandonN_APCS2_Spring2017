// Brandon Nguyen, 2/8/17 2nd Period
public class AdvanceTicket extends Ticket {
	private int days;
	public AdvanceTicket(int number, int days){
		//creates new ticket using extended code from ticket
		super(number);
		this.days = days;
	}
	public double getPrice(){
		//returns the price depending on the how many days before the
		//ticket was bought
		if(this.days >= 10){
			return 30.0;
		}else{
			return 40.0;
		}
	}
}
