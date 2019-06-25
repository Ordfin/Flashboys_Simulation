import java.util. *;
public class Flashboyz {
	
	static int duration; //auction duration
	static double epsilon; //minimum tick 
	static double iota; //minimum increase percent
	static int s; //smallest initial bid
	static double l; //loss function
	

	public static void main(String[] args) {
		int time = 0; 
		ArrayList<Bid> BidList;
		int profit; 
		int loss; 
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter an auction duration(in seconds)");
		int duration = sc.nextInt();
		
		System.out.println("Enter a minimum tick amount");
		double epsilon = sc.nextDouble();
		
		System.out.println("Enter a minimum increase percent");
		double iota = sc.nextDouble();
		
		System.out.println("Enter a smallest initial bid");
		int s = sc.nextInt();
		
		System.out.println("Enter a loss function percent");
		int l= sc.nextInt();
		
		System.out.println("Enter how many participants");
		int amt_players = sc.nextInt();
		
		ArrayList<Player> players = new ArrayList<>();
		
		for (int i=0; i<amt_players; i++) {
			System.out.println("Choose strategy for player " + i);
			String strategy = sc.nextLine();
			Player p = new Player(i, strategy);
			players.add(p);
		} //end of for
	}	//end of main
		
		public static void results(int profit1, int l1, ArrayList<Bid> allBids, ArrayList<Player> players) {
			
			int winner = allBids.get(allBids.size()-1).getPlayer(); 
			double win_amt = profit1 - (allBids.get(allBids.size()-1).getAmount());  
			System.out.println("The winner is player " + winner + " with a profit of " + win_amt);
			
			for (int i=0; i < players.size(); i++) {
				if (players.get(i).getId() != winner){
					
					double lost = (players.get(i).getBids().get(players.get(i).getBids().size()-1) .getAmount())*l1; 
					System.out.println("The loser is player " + players.get(i).getId() + " with a loss of " + lost);
				}
			}

  
		}//results
	
	

}//class