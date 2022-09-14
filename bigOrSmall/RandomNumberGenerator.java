package practical13;

import java.util.Random;

public class RandomNumberGenerator {
	public static int createCurrntNumber() {
		Random random = new Random();
		int randomCurrentNum = random.nextInt(9) + 1;
		return randomCurrentNum;
	}
	
	public static int createNextNumber() {
		Random random = new Random();
		int randomNextNum = random.nextInt(9) + 1;
		return randomNextNum;
	}
}
