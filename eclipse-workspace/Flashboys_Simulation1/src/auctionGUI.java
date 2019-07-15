import java.awt.*; 
import javax.swing.JFrame;
 
public class auctionGUI extends JFrame{
	public auctionGUI() {
		  JFrame auctionGUI = new JFrame();
	}

	  public void create(auctionGUI auctionGUI, String output) { 
		  	auctionGUI.setSize(400, 400); 
		  	auctionGUI.setLocation(300,100); 
		  	auctionGUI.setTitle("Auction");
			Container myContentPane = auctionGUI.getContentPane();
			auctionGUI.setLayout(new GridLayout(1,2));
			TextArea text1 = new TextArea();
			myContentPane.add(text1);
			text1.append(output+"");
		    setVisible(true);
	  } 
  }
 