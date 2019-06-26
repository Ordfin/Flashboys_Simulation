import java.util. *;

public class ReactiveCounterbidding extends Strategy{
	
	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, int profit) {	
		
		if (allBids.isEmpty()) {
			Bid b = new Bid(t, s, i);  
			allBids.add(b);
			bidsPlayer.add(b);
		}
		else if(bidsPlayer.isEmpty()) {
			double a = Math.min(Math.max(allBids.get(allBids.size()-1).getAmount() * (1+
					iota), allBids.get(allBids.size()-1).getAmount() + epsilon),
					profit);
			Bid b = new Bid(t, a, i);
			allBids.add(b);
			bidsPlayer.add(b);
		}
		else {
			if ((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				double a = Math.min(Math.max(allBids.get(allBids.size()-1).getAmount() * (1+
						iota), allBids.get(allBids.size()-1).getAmount() + epsilon),
						profit + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount());
				Bid b = new Bid(t, a, i);
				allBids.add(b);
				bidsPlayer.add(b);
			}
		}
	}

}
