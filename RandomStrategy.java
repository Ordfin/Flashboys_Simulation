import java.util.ArrayList;
	import java.util.TreeMap;
	import java.util.Random;


public class RandomStrategy extends Strategy{
	double amt;
		public void run(double t, double D, double s, int i, double iota, double epsilon, double loss_func, ArrayList<Bid> allBids, ArrayList<Bid> bidsPlayer, double profit, TreeMap<Double, ArrayList<Bid>> temp) {	



			if(t<D) {
				Random rand = new Random();
				if (t % rand.nextInt(5) == 0) { 
					double wait = t + rand.nextInt(5);
					if(allBids.isEmpty()) amt = rand.nextDouble();
					else amt = allBids.get(allBids.size()-1).getAmount() + rand.nextDouble(); 
					Bid b = new Bid(t, amt , i);
					allBids.add(b);
					bidsPlayer.add(b);
				}
			}
		}
			

}
