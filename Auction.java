import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Auction { //this is the right one  
	
	private int duration; //auction duration
	private double epsilon; //minimum tick 
	private double iota; //minimum increase percent
	private int s; //smallest initial bid
	private double l; //loss function
	private ArrayList<Bid> BidList = new ArrayList<Bid>();
	private double profit; 
	private int amt_players;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	public void getInput() {
	
		duration = Integer.parseInt((JOptionPane.showInputDialog("Enter an auction duration(in seconds)")));
		epsilon = Integer.parseInt(JOptionPane.showInputDialog("Enter a minimum tick amount"));
		iota = Double.parseDouble(JOptionPane.showInputDialog("Enter a minimum increase percent"));
		s = Integer.parseInt(JOptionPane.showInputDialog("Enter a smallest initial bid"));
		l= Double.parseDouble(JOptionPane.showInputDialog("Enter a loss function percent"));
		profit = Integer.parseInt(JOptionPane.showInputDialog("Enter oppertune profit"));
		amt_players = Integer.parseInt(JOptionPane.showInputDialog("Enter how many participants"));
		
			
		for (int i=0; i<amt_players; i++) {
			String strategy = JOptionPane.showInputDialog("Choose strategy for player " + i);
			Player p = new Player(i, strategy);
			players.add(p);
		}

		
	}
	
	
	
	public void results() {
		
		int winner = BidList.get(BidList.size()-1).getPlayer(); 
		
		double win_amt = profit - (BidList.get(BidList.size()-1).getAmount());  
		System.out.println("The winner is player " + winner + " with a profit of " + win_amt);
		
		for (int i=0; i < players.size(); i++) {
			if (players.get(i).getId() != winner){
				
				double lost = (players.get(i).getBids().get(players.get(i).getBids().size()-1) .getAmount())*l; 
				System.out.println("The loser is player " + players.get(i).getId() + " with a loss of " + lost);
			}
		}

	}
	
	
	public void auction() {
		int time = 0;
		while (time < duration) {  
			for (int i=0; i< amt_players; i++) {
				players.get(i).getS().run (time, duration, s, i, iota, epsilon, l, BidList, players.get(i).getBids());
			}
			time++;	
		}
		results(); 

	}
}




