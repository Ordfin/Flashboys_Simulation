import java.util. *;

import javax.swing.JOptionPane;

public class ReactiveCounterbidding extends Strategy{
	
	private double latency;
	

	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double profit, TreeMap<Double, ArrayList<Bid>> temp) {	
		
		if (allBids.isEmpty()) { //if no bid yet, place first bid
			Bid b = new Bid(t, s, i);  
			allBids.add(b);
			bidsPlayer.add(b);
		}
		
		else {
			int counter = 0;
			while(counter <(allBids.size())){
				if((allBids.get(counter).getTime() + latency) == t){
					 Bid pb = allBids.get(counter); //previous bid
			
					 if(bidsPlayer.isEmpty()) { //if you haven't bid yet
						double a = Math.min(Math.max(pb.getAmount() * (1+
								iota), pb.getAmount() + epsilon),
								profit);
						Bid b = new Bid(t, a, i);
						super.addBid(temp, bidsPlayer, a, b);
					}
					else { //if both players have bid
						if ((pb.getPlayer() != i) 
								&& (pb.getAmount() > bidsPlayer.get(bidsPlayer.size()-1).getAmount())) {
							double a = Math.min(Math.max(pb.getAmount() * (1+
									iota), pb.getAmount() + epsilon),
									profit + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount());
							Bid b = new Bid(t, a, i);
							super.addBid(temp, bidsPlayer, a, b);
							}//&&
					}//else
				}//if==t
				counter++;
			}//while
		
		}//else
	}//run

	
	public void enterValues() {
			
	    	this.latency = Double.parseDouble(JOptionPane.showInputDialog("Enter latency"));
	}

}
