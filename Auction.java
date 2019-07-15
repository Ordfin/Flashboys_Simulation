//import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.TreeMap;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Auction { //this is the right one  
	
	private int auction_id;
	private double duration; //auction duration
	private double epsilon = .05; //minimum tick 
	private double iota = .125; //minimum increase percent
	private double s = .5; //smallest initial bid
	private double l = .10; //loss function
	private ArrayList<Bid> BidList = new ArrayList<Bid>();
	private double profit = 30; 
	private int amt_players;
	private ArrayList<Player> players = new ArrayList<Player>();

	
	public void getInput(int n1, int n2, int a) {
		PoissonDistribution pd = new PoissonDistribution(15);
		duration = pd.sample(); //Generate a random value sampled from this distribution.

		try {
			/*
			 * duration = Integer.parseInt((JOptionPane.
			 * showInputDialog("Enter an auction duration(in seconds)"))); epsilon =
			 * Double.parseDouble(JOptionPane.showInputDialog("Enter a minimum tick amount")
			 * ); iota = Double.parseDouble(JOptionPane.
			 * showInputDialog("Enter a minimum increase percent")) * .01; s =
			 * Integer.parseInt(JOptionPane.showInputDialog("Enter a smallest initial bid"))
			 * ; l= Double.parseDouble(JOptionPane.
			 * showInputDialog("Enter a loss function percent")) * .01; profit =
			 * Integer.parseInt(JOptionPane.showInputDialog("Enter opportune profit"));
			 */
			amt_players = 2;
			String s = "ReactiveCounterbidding";
			String sn = "RandomStrategy";
			auction_id = a;
			Player p1 = new Player(0,s, n1);
			Player p2 = new Player(1, sn, n2);
			players.add(p1);
			players.add(p2);
//			amt_players = Integer.parseInt(JOptionPane.showInputDialog("Enter how many participants"));
//	
//	
//	
//				
//			for (int i=0; i<amt_players; i++) {
//			
//				Object[] options1 = { "Reactive Counterbidding", "Blind Raising"};
//		
//		        JPanel panel = new JPanel();
//		        panel.add(new JLabel("Select Strategy for player " + i));
//		        
//		        int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
//		                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
//		                null, options1, null);
//		        if (result == JOptionPane.YES_OPTION){
//		        	String s = "ReactiveCounterbidding";
//		        	Player p = new Player(i,s, n1);
//		    		players.add(p);
//	
//		        }
//		        if (result == JOptionPane.NO_OPTION){ 
//		        	String s = "BlindRaising";
//		        	Player p = new Player(i,s, n2);
//		    		players.add(p);
//	
//		        }
//	
//	        }
		}
		catch(Exception e) {
			System.exit(0);
		}
	
		

		
	}
	
	
	public void results(JSONArray j2) throws FileNotFoundException {

        
		Map<String, Object> map = new LinkedHashMap<>();


        // putting data to JSONObject 
        map.put("auction_id", auction_id); 
    
// 		JSONArray ja = new JSONArray(); 
//	          
// 		for(int j = 0; j<BidList.size(); j++){ 
//			// for address data, first create LinkedHashMap 
// 			Map<String, Object> m = new LinkedHashMap(); 		        
//		    m.put("time", BidList.get(j).getTime()); 
//		    m.put("amount", BidList.get(j).getAmount()); 
//		    m.put("player", BidList.get(j).getPlayer());
//		          
//		    // adding map to list 
//		    ja.add(m); 
//
//		  } 
// 		// putting address to JSONObject 
// 		map.put("Bids", ja); 

		int winner = BidList.get(BidList.size()-1).getPlayer(); 
		double win_amt = profit - (BidList.get(BidList.size()-1).getAmount());  
		
        Map<String, Object> mp = new LinkedHashMap(); 		        
        mp.put("winner_id", winner);
        mp.put("profit", win_amt);
        
		map.put("winner", mp);
		
		
		
		
		for (int i=0; i < players.size(); i++) {
			if (players.get(i).getId() != winner){
				
				double loss = (players.get(i).getBids().get(players.get(i).getBids().size()-1) .getAmount())*(-l); 
				//output += "The loser is player " + players.get(i).getId() + " with a loss of " + lost + "\n";
				mp = new LinkedHashMap<>();
				mp.put("loser_id", players.get(i).getId());
		        mp.put("loss", loss);
		        map.put("loser", mp);
		        
//			  JOptionPane.showMessageDialog(null, output);
//			  System.out.println("Duration was " + duration);
			}			
		}
		map.put("duration", duration);
		j2.add(map);
	}
	

	
	
	
	public void auction(JSONArray j2) throws FileNotFoundException {
		TreeMap<Double, ArrayList<Bid>> temp = new TreeMap<>();

		double time = 0;
		while (time < duration) {  
			for (int i=0; i< amt_players; i++) {

				players.get(i).getS().run(time, duration, s, i, iota, epsilon, l, BidList, players.get(i).getBids(), profit, temp);
			}
			for (Double  entry : temp.keySet()) {
				  ArrayList<Bid> values = temp.get(entry);
				  if(values.size() > 1) Collections.shuffle(values);
				  for(int i=0; i<values.size(); i++) {
					  BidList.add(values.get(i));
				  }
			}
			temp.clear();
			time+= .5;	
		} 
		results(j2);
	}
}	
