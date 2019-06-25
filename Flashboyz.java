import java.util. *;
public class Flashboyz {
	 
	

	public static void main(String[] args) {
		
//		int duration; //auction duration
//		double epsilon; //minimum tick 
//		double iota; //minimum increase percent
//		int s; //smallest initial bid
//		double l; //loss function
//		ArrayList<Bid> BidList;
//		double profit; 
//		int loss;
//		int amt_players;
//		
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
//		l= sc.nextInt();
//		
//		System.out.println("Enter how many participants");
//		amt_players = sc.nextInt();
//		
//		System.out.println("Enter oppertune profit");
//		profit = sc.nextDouble();
//		
//		ArrayList<Player> players = new ArrayList<>();
//		
//		for (int i=0; i<amt_players; i++) {
//			System.out.println("Choose strategy for player " + i);
//			String strategy = sc.nextLine();
//			Player p = new Player(i, strategy);
//			players.add(p);
//		}
//	}	
//		
//		public static void results(double profit1, double l1, ArrayList<Bid> allBids, ArrayList<Player> players) {
//			
//			int winner = allBids.get(allBids.size()-1).getPlayer(); 
//			
//			double win_amt = profit1 - (allBids.get(allBids.size()-1).getAmount());  
//			System.out.println("The winner is player " + winner + " with a profit of " + win_amt);
//			
//			for (int i=0; i < players.size(); i++) {
//				if (players.get(i).getId() != winner){
//					
//					double lost = (players.get(i).getBids().get(players.get(i).getBids().size()-1) .getAmount())*l1; 
//					System.out.println("The loser is player " + players.get(i).getId() + " with a loss of " + lost);
//				}
//			}
//  
//		}
//		
//		
//		public void auction(int duration, double s, double epsilon, double iota, double loss, double profit, ArrayList<Bid> allBids, ArrayList<Player> players) {
//			int time = 0;
//			while (time < duration) {  
//				for (int i=0; i<players.size(); i++) {
//					players.get(i).getS().run (time, duration, s, i, iota, epsilon, loss, allBids, players.get(i).getBids());
//					time++;	
//				}
//				 
//			}
//			
//			
//			results(profit, loss, allBids, players); 
//
		}

	
	

}