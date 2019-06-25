import java.util.ArrayList;
import java.util.Scanner; 

public class BlindRaising extends Strategy{
	
	double f;
	

	
	public void run(double t, double D, double wait, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double s, double f, int k, int i) {	
		
		if(t<D) {
			// bids (starting_amount * (1+f)^k) every "wait" seconds
			if (t % wait == 0) {
				Bid b = new Bid(t, Math.pow(s *(1+f), k), i);

	public void run(double t, double D, double min_wait, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double s, double f, int i) {	
		
		if(t<D) {
			if (t % min_wait == 0) {

				Bid b = new Bid(t, s *(1+f), i); //wrong formula, ^k

				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
		return;	
	}
	
	public void enterValues() {
		
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter fractional increment");
    	double fi = sc.nextDouble();
      this.f = fi;
	}
	
	
}