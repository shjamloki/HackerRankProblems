package a.newproblems;

public class MarsExploration {
	public static void main(String[] args) {
		System.out.println(marsExploration("SOSTOT"));
	}
	
	 public static int countChanges(String message) {
	        String sos = "SOS";
	        int count = 0;
	        for (int i = 0; i < message.length(); i++) {
	            if (message.charAt(i) != sos.charAt(i % 3)) count++;
	        }
	        return count;
	    }

//Complete the marsExploration function below.
	static int marsExploration(String s) {
		int count = 0;

		if (s.length() % 3 != 0) {
			System.out.println("Not a complete msg");
			return -1;
		} else {
			int num = s.length() / 3;
			int index = 0;
			for (int i = 1; i <= num; i++) {
				String str = s.substring(index, index + 3);
				if(str.equals("SOS")) {
					index += 3;
					continue;
				}
				for (int j = 0; j < str.length(); j++) {
					switch (j) {
					case 0:
					case 2: {
						if (str.charAt(j) != 'S')
							count++;
						break;
					}
					case 1: {
						if (str.charAt(j) != 'O')
							count++;
						break;
					}
					}
				}
				index += 3;
			}
		}
		return count;
	}
}
