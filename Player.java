import java.util.ArrayList;
<<<<<<< HEAD
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
		

=======

public class Player {
	
	private int id;
	private Strategy s;
	private ArrayList<bid> bids;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Strategy getS() {
		return s;
	}
	public void setS(Strategy s) {
		this.s = s;
	}
	public ArrayList<bid> getBids() {
		return bids;
	}
	public void setBids(ArrayList<bid> bids) {
		this.bids = bids;
	}
	
	
	
>>>>>>> update
}
