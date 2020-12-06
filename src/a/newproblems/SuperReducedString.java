package a.newproblems;

public class SuperReducedString {
	
	public static void main(String[] args) {
		
		System.out.println(superReducedString("aabbccdd"));
		
	}
	// Complete the superReducedString function below.
    static String superReducedString(String s) {
    	StringBuilder st = new StringBuilder(s);
    	for(int i =0; i< st.length()-1;i++)
    	{
    		if(st.charAt(i)==st.charAt(i+1))
    		{
    			st.deleteCharAt(i);
    			st.deleteCharAt(i);
    			i =-1;
    		}
    	}
    	if(st.length()==0)return "Empty String";
    	else return st.toString();
    }
    static String superReducedString1(String st)
    {
    	StringBuffer s = new StringBuffer(st);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                s.delete(i-1, i+1);
                i = 0;
            }
        }
        if(s.length() == 0)return "Empty String";
        else return s.toString();
    }

}
