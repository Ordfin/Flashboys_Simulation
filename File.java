import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator; 
import org.json.simple.parser.*; 


public class File {
	 

	    public void write() throws FileNotFoundException  
	    { 
	    	int counter = 0;
	    	for (double i=1; i < 90; i+= 1) {
	    		counter++;
	    	
		    	// creating JSONObject 
		        JSONObject jo = new JSONObject(); 
		          
		        // putting data to JSONObject 
		        jo.put("Wait time", "1"); 
		        jo.put("Percent increase", Double.toString(i)); 
		        
		          
		        // writing JSON to file:"JSONExample.json" in cwd 
		        PrintWriter pw = new PrintWriter(Integer.toString(counter) + ".json"); 
		        pw.write(jo.toJSONString()); 
		          
		        pw.flush(); 
		        pw.close(); 
		    }
	    }
	    
 
	        public ArrayList<Double> read(int n) throws Exception  
	        { 
	            // parsing file "JSONExample.json" 
	            Object obj = new JSONParser().parse(new FileReader(Integer.toString(n) + ".json")); 
	              
	            // typecasting obj to JSONObject 
	            JSONObject jo = (JSONObject) obj; 
	              
	            ArrayList<Double> arr = new ArrayList<>();
	            
	            // getting firstName and lastName 
	            Double time = Double.parseDouble((String) jo.get("Wait time")); 
	            Double percent = Double.parseDouble((String) jo.get("Percent increase")); 
	              
	            arr.add(time);
	            arr.add(percent);
	              
	            return arr;
	        } 
	 

}
