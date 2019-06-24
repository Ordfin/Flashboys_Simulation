import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Player {
	private int ID; 
	Strategy strat;
	ArrayList<Bid> bidList = new ArrayList<bid>; 
	
	public Player(int ID) {
		Scanner dd = new Scanner(System.in);
		String[] choices = { "ReactiveCounterbidding", "BlindRaising" };
	    
		this.ID = ID; 
		this.Strategy = strat; 
		ArrayList<Bid> bl = new ArrayList<Bid>();
		
		//get user input
	}
	
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Strategy getStrat() {
		return strat;
	}

	public void setStrat(Strategy strat) {
		this.strat = strat;
	}

	public BidList getBl() {
		return bl;
	}

	public void setBl(BidList bl) {
		this.bl = bl;
	}
		

}
