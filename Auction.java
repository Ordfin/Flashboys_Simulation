import java.util.ArrayList;

public class Auction {
	
	ArrayList<Bid> allBids;
	
//	int profit; 
//	int loss; 
//	
//	ArrayList<Bid> BidList;
//	int duration;
//	double epsilon; //minimum tick 
//	double iota; //minimum increase percent
//	int s; //smallest initial bid
//	double l; //loss function
//	int player = 0; 
//	int time = 0; 
//	//while (player<2) {
//		//instantiate players
	
	public void auction(int D) {
		int time = 0;
		while (time < D) {
			player0.getStrategy.run(time);
			player1.getStrategy.run(time);
			time++; 
		}
		Winner = last person to bid; 
		Winnergets = Profit - array.mostrecentbid; 
		Lost = 1 - winner; 
		Loser gets = 1 + l;
	}


