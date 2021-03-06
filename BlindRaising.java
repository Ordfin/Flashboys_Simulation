import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;


public class BlindRaising extends Strategy{
	  
	private double f;
	private double wait;

	private double k = 0;

	
	

	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double profit, TreeMap<Double, ArrayList<Bid>> temp) {	
//		if (allBids.get(allBids.size()-1).getAmount() >= profit + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount()) {
//			return;
//		}


		if(t<D) {
			// bids (starting_amount * (1+f)^k) every "wait" seconds
			if (t % wait == 0) {
				double amt = Math.pow((1+f), k)*s;

				if (bidsPlayer.isEmpty()) {
					if (amt >= profit) return;
				}
				else if (amt >= profit + loss_func * bidsPlayer.get(bidsPlayer.size()-1).getAmount()) return;
				else if (!(bidsPlayer.isEmpty())) {
					if (amt < allBids.get(allBids.size()-1).getAmount()) 
						return; 
				}
				Bid b = new Bid(t, amt , i);
				super.addBid(temp, bidsPlayer, amt, b);
				k++;

			}
		}//if
	}//end run
		
	
	public void enterValues(int n) throws Exception {
		

		File f = new File();

		ArrayList<Double> temp = f.read(n);
    	double fi = temp.get(1) * .01;
    	double w = temp.get(0);
    	
    	this.wait = w;
    	this.f = fi;
	}
	
	
}