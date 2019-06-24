
public class player {
	private int ID; 
	Strategy strat;
	BidList bl; 
	
	public player(int ID, Strategy strat, BidList bl) {
		this.ID = ID; 
		this.strategy = strat; 
		ArrayList<bid> bl = new bidlist();
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
