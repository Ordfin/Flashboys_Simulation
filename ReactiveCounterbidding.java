import java.util. *;

import javax.swing.JOptionPane;

public class ReactiveCounterbidding extends Strategy{
	
	private double latency;
	

	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double profit, TreeMap<Double, ArrayList<Bid>> temp) {	
		
		if (allBids.isEmpty()) {
			Bid b = new Bid(t, s, i);
			super.addBid(temp, bidsPlayer, s, b);

		}
		else if(bidsPlayer.isEmpty()) { //if you haven't bid yet
			double a = Math.min(Math.max(allBids.get(allBids.size()-1).getAmount() * (1+
					iota), allBids.get(allBids.size()-1).getAmount() + epsilon),
					profit);
			Bid b = new Bid(t, a, i);
			super.addBid(temp, bidsPlayer, a, b);
		}
		else { //if both players have bid
			if ((allBids.get(allBids.size()-1).getPlayer() != i) 
					&& (allBids.get(allBids.size()-1).getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
				double a = Math.min(Math.max(allBids.get(allBids.size()-1).getAmount() * (1+
						iota), allBids.get(allBids.size()-1).getAmount() + epsilon),
						profit + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount());
				Bid b = new Bid(t, a, i);
				super.addBid(temp, bidsPlayer, a, b);
			}
		}
	}

	public void enterValues() {
			
	    	this.latency = Double.parseDouble(JOptionPane.showInputDialog("Enter fractional increment"));
	}

}

