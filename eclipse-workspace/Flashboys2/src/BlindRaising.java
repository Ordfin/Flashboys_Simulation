import java.util. *; 
public class BlindRaising {
	
	
	public void run(double t, double D, double min_wait, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double s, double f, int i) {	
		
		if(t<D) {
			if (t % min_wait == 0) {
				Bid b = new Bid(t, s *(1+f), i);
				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
		return;
		
		
	}
	
	
}
