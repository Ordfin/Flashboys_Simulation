import java.util. *; 
public class BlindRaising {
	
	
	public void run(double t, double D, double min_wait, ArrayList<bid> allBids, ArrayList<bid> bidsPlayer, double s, double f, int i) {	
		
		if(t<D) {
			if (t % min_wait == 0) {
				bid b = new bid(t, s *(1+f), i); //wrong formula, ^k
				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
		return;
		
		
	}
	
	
}
