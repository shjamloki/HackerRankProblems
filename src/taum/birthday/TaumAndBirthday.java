package taum.birthday;

public class TaumAndBirthday {

	public static void main(String[] args) {
		//27984 1402

		//619246 615589 247954   => 18192035842
		System.out.println(taumBday(27984, 1402, 619246, 615589, 247954));
		//System.out.println(taumBday(279, 14, 6192, 6155, 2479));
	}
	public static long taumBday(int b, int w, int bc, int wc, int z) {
		
		return (long)b * Math.min(bc, wc + z) + (long)w * Math.min(wc, bc + z);
		
	}
}
