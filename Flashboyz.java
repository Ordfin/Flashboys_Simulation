import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util. *;

public class Flashboyz {
	 
	

	public static void main(String[] args) throws Exception {
		
//		Files test = new Files();
//		test.write();
		PrintWriter writer = new PrintWriter("analysisTest.txt", "UTF-8");
		ArrayList<Auction> arr = new ArrayList<>();
		for (int i=1; i<25; i++) {
			Auction a = new Auction();
			a.getInput(1, i);
			String r = a.auction();
			System.out.println(r);
			//arr.add(a);

			writer.println(r);
			writer.println("\n");

		}
		writer.close();

		
		

		}

}