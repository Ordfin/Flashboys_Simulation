import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.util.TreeMap;


public class Auction { //this is the right one  
	
	private double duration; //auction duration
	private double epsilon; //minimum tick 
	private double iota; //minimum increase percent
	private double s; //smallest initial bid
	private double l; //loss function
	private ArrayList<Bid> BidList = new ArrayList<Bid>();
	private double profit; 
	private int amt_players;
	private ArrayList<Player> players = new ArrayList<Player>();

	
	public void getInput() {

		try {
			duration = Integer.parseInt((JOptionPane.showInputDialog("Enter an auction duration(in seconds)")));
			epsilon = Double.parseDouble(JOptionPane.showInputDialog("Enter a minimum tick amount"));
			iota = Double.parseDouble(JOptionPane.showInputDialog("Enter a minimum increase percent")) * .01;
			s = Integer.parseInt(JOptionPane.showInputDialog("Enter a smallest initial bid"));
			l= Double.parseDouble(JOptionPane.showInputDialog("Enter a loss function percent")) * .01;
			profit = Integer.parseInt(JOptionPane.showInputDialog("Enter opportune profit"));
			amt_players = Integer.parseInt(JOptionPane.showInputDialog("Enter how many participants"));
	
	
	
				
			for (int i=0; i<amt_players; i++) {
			
				Object[] options1 = { "Reactive Counterbidding", "Blind Raising"};
		
		        JPanel panel = new JPanel();
		        panel.add(new JLabel("Select Strategy for player " + i));
		        
		        int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
		                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
		                null, options1, null);
		        if (result == JOptionPane.YES_OPTION){
		        	String s = "ReactiveCounterbidding";
		        	Player p = new Player(i,s);
		    		players.add(p);
	
		        }
		        if (result == JOptionPane.NO_OPTION){ 
		        	String s = "BlindRaising";
		        	Player p = new Player(i,s);
		    		players.add(p);
	
		        }
	
	        }
		}
		catch(Exception e) {
			System.exit(0);
		}
	
		

		
	}
	
	
	public void results() {
		String output = ""; 
		  for(int j = 0; j<BidList.size(); j++){ 
			  String everything = BidList.get(j).toString(); 
			  output += everything +" "+ "\n"; 
		  } 
		
		output += "\n";
		int winner = BidList.get(BidList.size()-1).getPlayer(); 
		
		double win_amt = profit - (BidList.get(BidList.size()-1).getAmount());  
		output += "The winner is player " + winner + " with a profit of " + win_amt + "\n";
		
		for (int i=0; i < players.size(); i++) {
			if (players.get(i).getId() != winner){
				
				double lost = (players.get(i).getBids().get(players.get(i).getBids().size()-1) .getAmount())*(-l); 
				output += "The loser is player " + players.get(i).getId() + " with a loss of " + lost + "\n";
		
			  JOptionPane.showMessageDialog(null, output);
			}
		}

	}
	
	
	public void auction() {
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
			time++;	
		} 
		
		 
		 
			results(); 
	}
}	