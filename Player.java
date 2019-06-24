import java.util.ArrayList;

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
	
	
	
}
