import java.util.ArrayList;


public class Player {

	private int id;

	private Strategy strategy;
	private ArrayList<Bid> bids;

	
	public Player(int id, String strat, int n) throws Exception {
		
		
		this.id = id;
		
		switch (strat) { 
		
        case "BlindRaising":
            this.strategy = new BlindRaising();
            ((BlindRaising) strategy).enterValues(n);
            break; 
        case "ReactiveCounterbidding": 
            this.strategy = new ReactiveCounterbidding(); 
            ((ReactiveCounterbidding) strategy).enterValues();
            break; 
        case "RandomStrategy":
            this.strategy = new RandomStrategy();
            break; 
		}
		
		this.bids = new ArrayList<Bid>();

	}

	

	
	
	public int getId() {
		return id;
	}  
	public void setId(int id) {
		this.id = id;
	}
	public Strategy getS() {
		return this.strategy;
	}
	public void setS(Strategy strat) {
		this.strategy = strat;
	}
	public ArrayList<Bid> getBids() {
		return bids;
	}
	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
	
	
	
}
