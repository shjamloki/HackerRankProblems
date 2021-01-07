package a.newproblems;

public class SeparateBeautifulNumbers {

	public static void main(String[] args) {
		//separateNumbers("99910001001");
		//separateNumbers("101103");
		separateNumbers("10001001100210031004100510061007");
	}
	static void separateNumbers1(String s)
	{
		boolean valid = false;
		long firstx = -1;
		// Try each possible starting number
		for (int i=1; i<=s.length()/2; ++i) {
			long x = Long.parseLong(s.substring(0,i));
			firstx = x;
		   // Build up sequence starting with this number
			String test = Long.toString(x);
			while (test.length() < s.length()) {
				test += Long.toString(++x);
			}
			// Compare to original
			if (test.equals(s)) {
				valid = true;
				break;
			}
		}
		System.out.println(valid ? "YES " + firstx : "NO");
	}
	// Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        int n = s.length();
        boolean isComplete=false;
        String result ="";
        String firstNum = "";
        for(int i =1;i<=n && !isComplete;i++)
        {
            long thisNum =0;
            int nextIndex = i;
            int prevIndex = 0;
            long prevNum =0;
            int constant = 0;
            do
            {
                String strNum = s.substring(prevIndex,nextIndex);
                if(nextIndex==i && prevIndex==0)firstNum = strNum;
                thisNum = Long.parseLong(strNum);
                if(strNum.matches("[9]+")) {
                    constant ++; 
                }
                if(strNum.startsWith("0")) {
                    isComplete=true;
                    result="NO";
                    break;
                }
                else if(prevIndex==0 && ((strNum.length()*2)+constant) > s.length())
                {
                	 isComplete=true;
                     result="NO";
                     break;
                }
                
                prevIndex = nextIndex;
                if(prevNum ==0)
                {
                    prevNum=thisNum;
                }
                else
                {
                    if(prevNum != (thisNum-1))
                    {
                        break;
                    }
                    if(nextIndex >= s.length())
                    {
                        isComplete = true;
                        result="Yes";
                        break;
                    }
                    prevNum = thisNum;
                }
                nextIndex +=i+constant;
            }while(nextIndex<=s.length());
            if(isComplete)break;
        }
        if(isComplete){
             if(result.equals("NO")){
                 System.out.println("NO");
             }
             else
             {
                System.out.println("YES "+firstNum); 
             }
             
        }
        else System.out.println("NO");
     }
}
