import java.util. *;
public class Flashboyz {
	
	public static void main(String[] args) {
//		int profit; 
//
//		int loss; 
//		ArrayList<Bid> BidList;
//		int duration;
//		double epsilon; //minimum tick 
//		double iota; //minimum increase percent
//		int s; //smallest initial bid
//		double l; //loss function
//		int player = 0; 
//		int time = 0; 
//		while (player<2) {
//			//instantiate players
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter an auction duration(in seconds)");
		int Duration = sc.nextInt();
		
		System.out.println("Enter a minimum tick amount");
		double epsilon = sc.nextDouble();
		
		System.out.println("Enter a minimum increase percent");
		double iota = sc.nextDouble();
		
		System.out.println("Enter a smallest initial bid");
		int min_start = sc.nextInt();
		
		System.out.println("Enter how many participants");
		int amt_players = sc.nextInt();
		
		ArrayList<Player> players = new ArrayList<>();
		
		for (int i=0; i<amt_players; i++) {
			System.out.println("Choose strategy for player " + i);
			String strategy = sc.nextLine();
			Player p = new Player(i, strategy);
			players.add(p);
		}
  
	}
	
	

}
