package a.newproblems;

/**
 * We say that a string contains the word hackerrank if a subsequence of its
 * characters spell the word hackerrank. Remember that a subsequence maintains
 * the order of characters selected from a sequence.
 *
 * More formally, let p0,p1....p9 be the respective indices of h, a, c, k, e, r,
 * r, a, n, k in string s. If p0<p1<p2<.....<p9 is true, then s contains
 * hackerrank. For each query, print YES on a new line if the string contains
 * hackerrank, otherwise, print NO.
 */
public class HackerRankInString {

	public static void main(String[] args) {
		System.out.println(checkIfIsHacker("hackerrank"));
		System.out.println(checkIfIsHacker2("hackerrank"));
	}
	private static String checkIfIsHacker(String s) {

		String str = "hackerrank";
		if (s.length() < str.length()) {
			return "NO";
		}
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (j < str.length() && s.charAt(i) == str.charAt(j)) {
				j++;
			}
		}
		return (j == str.length() ? "YES" : "NO");

	}
	private static String checkIfIsHacker2(String s) {
		   if(s.matches(".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*")){
	            return "YES";
	        } else {
	            return "NO";
	        }
	}
}
