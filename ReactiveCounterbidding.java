import java.util. *;

public class ReactiveCounterbidding {
	
	public void run(double t, int i, double s, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer) {
		
		if (allBids.isEmpty()) {
			Bid b = new Bid(t, s, i);
			allBids.add(b);
			bidsPlayer.add(b);
		}
		else {
			if ((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				Bid b = new Bid(t, s, i);
				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
	}

}
