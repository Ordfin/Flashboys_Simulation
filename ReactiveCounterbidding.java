import java.util. *;

public class ReactiveCounterbidding extends Strategy{
	
	public void run(double t, int i, double s, double iota, double epsilon, double loss_func,  ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer) {
		
		if (allBids.isEmpty()) {
			Bid b = new Bid(t, s, i);
			allBids.add(b);
			bidsPlayer.add(b);
		}
		else {
			if ((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				double a = Math.min(Math.max(bidsPlayer.get(bidsPlayer.size()-1).getAmount() * (1+
						iota), bidsPlayer.get(bidsPlayer.size()-1).getAmount() + epsilon),
						1 + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount());
				Bid b = new Bid(t, a, i);
				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
	}

}
