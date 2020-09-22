package cats.mouse;

public class CatsAndMouse {

	/**
	 * python3  version
	 * def catAndMouse(x, y, z): 
	 * a = abs(x-z)
	 * b = abs(y-z)
	 * return "Cat A" if a<b else "Cat B" if b<a else "Mouse C"
	 */
	// Complete the catAndMouse function below.
	static String catAndMouse(int x, int y, int z) {
		int absVal =Math.abs(x-z)-Math.abs(y-z);
		if(absVal > 0)
		{
			return "Cat B";
		}
		else if (absVal < 0)
		{
			return "Cat A";
		}
		else 
		{
			return "Mouse C";
		}
	}
	public static void main(String[] args) {
		System.out.println(catAndMouse(1, 2, 3));
	}
}
