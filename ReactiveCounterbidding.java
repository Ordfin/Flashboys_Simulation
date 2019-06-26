import java.util. *;

public class ReactiveCounterbidding extends Strategy{
	
	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double profit, TreeMap<Double, ArrayList<Bid>> temp) {	
		
		if (allBids.isEmpty()) {
			Bid b = new Bid(t, s, i);
			if(temp.containsKey(s)) {
				temp.get(s).add(b);	
			}
			else if (!temp.containsKey(s)) {
				ArrayList<Bid> tempList = new ArrayList<>();
				tempList.add(b);
				temp.put(s, tempList);
			}				
			bidsPlayer.add(b);
		}
		else if(bidsPlayer.isEmpty()) {
			double a = Math.min(Math.max(allBids.get(allBids.size()-1).getAmount() * (1+
					iota), allBids.get(allBids.size()-1).getAmount() + epsilon),
					profit);
			Bid b = new Bid(t, a, i);
			if(temp.containsKey(a)) {
				temp.get(a).add(b);	
			}
			else if (!temp.containsKey(a)) {
				ArrayList<Bid> tempList = new ArrayList<>();
				tempList.add(b);
				temp.put(a, tempList);
			}				
			bidsPlayer.add(b);
		}
		else {
			if ((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				double a = Math.min(Math.max(allBids.get(allBids.size()-1).getAmount() * (1+
						iota), allBids.get(allBids.size()-1).getAmount() + epsilon),
						profit + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount());
				Bid b = new Bid(t, a, i);
				if(temp.containsKey(a)) {
					temp.get(a).add(b);	
				}
				else if (!temp.containsKey(a)) {
					ArrayList<Bid> tempList = new ArrayList<>();
					tempList.add(b);
					temp.put(a, tempList);
				}				
				bidsPlayer.add(b);
			}
		}
	}

}
