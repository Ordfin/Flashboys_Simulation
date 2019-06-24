
public class Bid {

	private double time; //in econds
	private double amount;
	private int player;
	

	public Bid(double t, double amt, int p) {
		time = t;
		amount = amt;
		player = p; 
	}
	
	public static void trying(int i) {
		int t;
		t = i+i;
	}
	
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	
}
