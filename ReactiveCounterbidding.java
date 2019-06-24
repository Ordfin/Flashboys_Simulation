import java.util. *;

public class ReactiveCounterbidding {
	
	public void run(double t, int i, double s, ArrayList<bid> allBids, ArrayList<bid> bidsPlayer) {
		
		if (allBids.isEmpty()) {
			bid b = new bid(t, s, i);
			allBids.add(b);
			bidsPlayer.add(b);
		}
		else {
			if ((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				bid b = new bid(t, s, i);
				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
	}

}
