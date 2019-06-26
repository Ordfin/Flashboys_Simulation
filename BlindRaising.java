import java.util.ArrayList;
import java.util.Scanner; 
import javax.swing.JOptionPane;


public class BlindRaising extends Strategy{
	  
	private double f;
	private int wait;
	private static int k=0;
	
	
	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer) {	
		if (allBids.get(allBids.size()-1).getAmount() >= 1 + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount()) {
			return;
		}

		if(t<D) {
			// bids (starting_amount * (1+f)^k) every "wait" seconds
			if (t % wait == 0) {
				double amt = Math.pow(s *(1+f), k);
				if (!(bidsPlayer.isEmpty())) {
					if (amt < allBids.get(allBids.size()-1).getAmount()) 
						return; 
				}
				Bid b = new Bid(t, amt , i);
				allBids.add(b);
				bidsPlayer.add(b);
				k++;
			}
		}
		return;	
	}
	
	public void enterValues() {
		
    	double fi = Double.parseDouble(JOptionPane.showInputDialog("Enter fractional increment"));
    	int w = Integer.parseInt(JOptionPane.showInputDialog("Enter time wait interval"));
    	
    	this.wait = w;
    	this.f = fi;
	}
	
	
}
