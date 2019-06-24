import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Player {

	private int id;
	private Strategy s;
	private ArrayList<Bid> bids;

	
	public Player(int id) {
		Scanner dd = new Scanner(System.in);
		String[] choices = { "ReactiveCounterbidding", "BlindRaising" };
	}
	

	
	
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
	public ArrayList<Bid> getBids() {
		return bids;
	}
	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
	
	
	
}
