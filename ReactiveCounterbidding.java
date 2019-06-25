import java.util. *;

public class ReactiveCounterbidding extends Strategy{
	
	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer) {	
		
		if (allBids.isEmpty()) {
			Bid b = new Bid(t, s, i);
			allBids.add(b);
			bidsPlayer.add(b);
		}
		if (bidsPlayer.isEmpty()) {
			Bid b = new Bid(t, s+1, i);
			allBids.add(b);
			bidsPlayer.add(b);
		}
		else if  
			((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				
				double a = Math.min(Math.max(bidsPlayer.get(bidsPlayer.size()-1).getAmount() * (1+
						iota), bidsPlayer.get(bidsPlayer.size()-1).getAmount() + epsilon),
						1 + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount());
				//min(max($b1 ×(1+ι), $b1 + epsilon), 1 + `l($b1))
				
				Bid b = new Bid(t, a, i);
				allBids.add(b);
				bidsPlayer.add(b);
		}
	}

}
