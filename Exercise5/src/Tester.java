// Brandon Nguyen, 2/8/17 2nd Period
public class Tester {
	public static void main(String[] args) {
		Ticket a = new WalkupTicket(10);
		System.out.println(a.getPrice());
		System.out.println(a.toString());
		
		Ticket b = new AdvanceTicket(13, 5);
		System.out.println(b.getPrice());
		System.out.println(b.toString());
		
		Ticket c = new StudentAdvanceTicket(20, 10);
		System.out.println(c.getPrice());
		System.out.println(c.toString());

	}

}