import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util. *;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Flashboyz {
	 
	

	public static void main(String[] args) throws Exception {
		
		JSONObject jo = new JSONObject();
		JSONArray j2 = new JSONArray();
        
        
		for (int i=1; i<26; i++) {
			Auction a = new Auction();
			a.getInput(1, i, i);
			a.auction(j2);

		}
		
		jo.put("Auction", j2);
 
	    // writing JSON to file:"AuctionData2.0.json" in cwd 
	    PrintWriter pw = new PrintWriter("AuctionData2.0.json"); 
	    pw.write(jo.toJSONString()); 
	        
	    pw.flush(); 
	    pw.close();
		}

}