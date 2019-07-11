import java.io.FileNotFoundException;
import java.util. *;

import org.apache.commons.math3.*;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.random.SynchronizedRandomGenerator;
import org.apache.commons.math3.random.Well1024a;
public class Flashboyz {
	 
	

	public static void main(String[] args) throws Exception {
		
//		Files test = new Files();
//		test.write();
		Auction a = new Auction();
		a.getInput();
		a.auction();

		
		

		}

}