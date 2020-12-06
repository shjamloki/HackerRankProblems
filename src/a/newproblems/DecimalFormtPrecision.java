package a.newproblems;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalFormtPrecision {
public static void main(String[] args) {
	String s = "0.56999999999999995";
	String s1 = "0.55999999999999995";
	DecimalFormat df = new DecimalFormat("0.0000000000");
	df.setRoundingMode(RoundingMode.DOWN);
	//half even is default
	//df.setRoundingMode(RoundingMode.HALF_EVEN);
	System.out.println("s = > "+df.format(new BigDecimal(s)));	
	System.out.println("s1 = > "+df.format(new BigDecimal(s1)));
}
}
