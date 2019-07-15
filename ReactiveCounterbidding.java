import java.util. *;
import org.apache.commons.math3.distribution.PoissonDistribution;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


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
					 Bid pb = allBids.get(counter); //previou bid
			
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
			
			Object[] options1 = { "Latency", "No Latency"};
	
	        JPanel panel = new JPanel();
	        panel.add(new JLabel("Select latency"));
	        
	        int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
	                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
	                null, options1, null);
	        if (result == JOptionPane.YES_OPTION){
	        	PoissonDistribution pdist = new PoissonDistribution(3);
	    		this.latency = pdist.sample(); //Generate a random value sampled from this distribution.

	        }
	        if (result == JOptionPane.NO_OPTION){ 
		    	this.latency = 0;
	        }
	     System.out.println("Latency of player: " + this.latency);
	}

}
