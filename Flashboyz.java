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
		int l= dd.nextInt();
		
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
