package a.newproblems;

import java.util.ArrayList;
import java.util.List;

public class SeparateBeautifulNumbers {

	public static void main(String[] args) {
		separateNumbers("99910001001");
	}
	// Complete the separateNumbers function below.
    static void separateNumbers(String s) {
    	int n = s.length();
    	List<Integer>collect = new ArrayList<>();
    	boolean isFound=false;
    	for(int i =1;i<=n && !isFound;i++)
    	{
    		if(n%i==0)
    		{
    			int step=i;
    			int numOfSteps= n/i;
    			collect.clear();
    			for(int j =0;j < numOfSteps;j+=step) {
    				collect.add(Integer.parseInt(s.substring(j,j+step)));
    			}
    			int prev=0;
    			for (int j = 0; j < collect.size(); j++) {
					if(j==0) {
						prev=collect.get(j);
						continue;
					}
					else if(collect.get(j) != prev+1)
					{
						break;
					}
					else if(j==collect.size()-1)
					{
						isFound=true;
					}
				}
    		}
    	}
    	if(isFound && !collect.isEmpty())System.out.println("Yes "+collect.get(0)); 
		else System.out.println("No");
    }
}
