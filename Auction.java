import java.util.ArrayList;
import java.util.Scanner;

public class Auction {
	
	private int duration = 15; //auction duration
	private double epsilon = .0001; //minimum tick 
	private double iota = .15; //minimum increase percent
	private int s = 3; //smallest initial bid
	private double l = .3; //loss function
	private ArrayList<Bid> BidList;
	private double profit = 100; 
	private int amt_players = 2;
	private ArrayList<Player> players;
	
	
	public void getInput() {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter an auction duration(in seconds)");
//		duration = sc.nextInt();
//		
//		System.out.println("Enter a minimum tick amount");
//		epsilon = sc.nextDouble();
//		
//		System.out.println("Enter a minimum increase percent");
//		iota = sc.nextDouble();
//		
//		System.out.println("Enter a smallest initial bid");
//		s = sc.nextInt();
//		
//		System.out.println("Enter a loss function percent");
//		l= sc.nextDouble();
//		
//		System.out.println("Enter how many participants");
//		amt_players = sc.nextInt();
//		
//		System.out.println("Enter oppertune profit");
//		profit = sc.nextDouble();
//		
		players = new ArrayList<>();
		BidList = new ArrayList<>();
		String strategy;

		for (int i=0; i<amt_players; i++) {
			System.out.println("Choose strategy for player " + i);
			//strategy = sc.next();
			Player p = new Player(i, "ReactiveCounterbidding");
			players.add(p);
			System.out.println(p.getS());
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
			for (int i=0; i<players.size(); i++) {
				players.get(i).getS().run (time, duration, s, i, iota, epsilon, l, BidList, players.get(i).getBids());
				
			}
			time++;
		}
		for (int i=0; i<BidList.size(); i++) {
			System.out.println("Time " + BidList.get(i).getTime()+ " Player " + BidList.get(i).getPlayer() + " bids " + BidList.get(i).getAmount());
		}
		
		results(); 

	}
	
}




