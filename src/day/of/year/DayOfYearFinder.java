package day.of.year;

public class DayOfYearFinder {

	public static void main(String[] args) {
		System.out.println(dayOfProgrammer(2100));
	}
	
	// Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
    	if(year <= 1917)
    	{
    		if(year%4==0)
    		{
    			return "12.09."+year;
    		}
    		else
    		{
    			return "13.09."+year;
    		}
    	}
    	else if(year > 1918)
    	{
    		if(year %400 ==0 || (year%4==0 && year%100 !=0))
    		{
    			return "12.09."+year;
    		}
    		else
    		{
    			return "13.09."+year;
    		}
    	}
    	else 
    	{
    		//This means that in 1918, February 14 was the 32nd day of the year in Russia.
    		/**
    		 * 1918%4 = 2 so not leap year hence 28 days. 
    		 * feb   march+ apr+ may+ june+july+ aug + sept
    		 * 32+14+  31  + 30 + 31 + 30 + 31 + 31  + 31 = 
    		 * 
    		 * 32+14 = 46 - feb
    		 *         31 - march =>77
    		 *         30 - april =>107
    		 *         31 - may   =>138
    		 *         30 - june  =>168
    		 *         31 - july  =>199
    		 *         31 - aug   =>230
    		 *         26 days of sept ==>26.09.1918
    		 */
    		return "26.09.1918";
    	
    	}

    }
}
