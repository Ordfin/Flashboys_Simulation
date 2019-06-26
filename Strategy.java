import java.util.ArrayList;
import java.util.TreeMap;

abstract class Strategy {
	public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double profit, TreeMap<Double, ArrayList<Bid>> temp) 
	{
		
		return;
	}
	public void addBid(TreeMap<Double, ArrayList<Bid>> temp, ArrayList<Bid> bidsPlayer, double s, Bid b){
		if(temp.containsKey(s)) {
			temp.get(s).add(b);	
		}
		else if (!temp.containsKey(s)) {
			ArrayList<Bid> tempList = new ArrayList<>();
			tempList.add(b);
			temp.put(s, tempList);
		}				
		bidsPlayer.add(b);
	}


}
