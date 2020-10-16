package encrypt.string;


/**
 * def encryption(s):
 *    c = math.ceil(math.sqrt(len(s)))
 *    p = ' '.join(map(lambda x: s[x::c], range(c)))
 *    return p
 *
 */
public class EncryptedString {
	public static void main(String[] args) {
		System.out.println(encryption3("haveaniceday"));
	}
	
	static String encryption3(String s) {
		String line = s.replace(" ", "");
		int cols = (int) Math.ceil(Math.sqrt(line.length()));
		StringBuffer sB = new StringBuffer();

		for (int index = 0; index < cols; index++) {
			for (int i = index; i < line.length() && i < (i + cols); i += cols) {
				sB.append(line.charAt(i));
			}
			sB.append(" ");
		}
		return sB.toString();

	}
	
	static String encryption2(String s)
	{
		StringBuilder result = new StringBuilder();
		s=s.replaceAll("\\s","");
	    int n=s.length(),i,x=0,j=0;
	    char ch;
	    double r= Math.sqrt(n);
	    double c= Math.ceil(r),f = Math.floor(r);

	    if(c*f<n)
	        f+=1;

	    for(i=0;i<c;i++) {
	        for(j=0;j<f;j++) {

	            if(i+x>=n)
	                break;

	            ch = s.charAt(i + x);
	            result.append(ch);
	            x = x + (int) (c);

	        }
	        result.append(" ");
	        x=0;
	    }
	    return result.toString();
	}
	//Complete the encryption function below.
	static String encryption(String s) {
		
		// my solution
		s = s.replaceAll(" ","");
		int length = s.length();
		int rows = (int)Math.floor(Math.sqrt(length));
		int columns = (int)Math.ceil(Math.sqrt(length));
		if((rows *columns) < length)
		{
			rows++;
		}
		
		String []tokens = new String[rows];
		int count =0;
		for(int i=0;i<s.length(); i = i+columns)
		{
			if((i+columns) < s.length())
			{
			tokens[count]=s.substring(i,i+columns);
			}
			else
			{
				tokens[count]=s.substring(i);
			}
			count++;
		}
		StringBuilder result = new StringBuilder();
		for (int j =0; j< columns;j++)
		{
			for (int k = 0; k<tokens.length; k++)
			{
				if(j <tokens[k].length())
				result.append(tokens[k].charAt(j));
			}
			if(j !=columns-1)
			result.append(" ");
		}
		return result.toString();
	}
}
