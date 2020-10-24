import java.nio.charset.StandardCharsets;

public class HextoByteArray {
	public static void main(String[] args) {
		new HextoByteArray().fromHexValue(null);
	}
	public void fromHexValue(byte [] bytes)
	{
		//
		byte [] test = "00000000/0d19bf50".getBytes();
		System.out.println(test.length);
		String restartPositionHex = new String(test, StandardCharsets.UTF_8);
	    System.out.println(restartPositionHex);
	}
}
