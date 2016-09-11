import java.util.Random;

public class RandomUtil {

	public static float randReal(float f) {
		return (new Random().nextFloat()) * f;
	}

	public static int randNat(int i) {
		return 1 + (int) randReal(i);
	}

	public static int randNatAvg(int a) {
		return randNat(2 * a - 1);
	}

	// a Boolean function that returns true with probability p, false otherwise.
	public static boolean randomBool(float p) {
		float r = new Random().nextFloat();
		return (r <= p);
	}
	
	// a Boolean function that returns true once every n calls, on average.
	public static boolean randomEvent(int n) {
		return randomBool((float) (1.0 / n));
	}

}
