package time.in.words;

/**
 *#!/bin/python3
 *ByOne=[0,'one','two','three','four','five','six','seven','eight','nine','ten','eleven','twelve',
 *     'thirteen','fourteen','fifteen','sixteen','seventeen','eighteen','ninteen','twenty']
 *     ByQua=["%s o' clock", "quarter past %s", "half past %s", "quarter to %s"]
 *     for i in range(1,10):
 *       ByOne.append('twenty %s'%ByOne[i])
 *       
 * h,m=int(input()),int(input())
 * hour=ByOne[h] if (m<31) else ByOne[h+1]
 * if not m%15:
 *  print(ByQua[m//15] % hour)
 * elif m<30:
 *  print("%s minute"%ByOne[m]+"s"*(m==1)+ " past %s"%hour)
 * else:
 *   print("%s minute"%ByOne[60-m]+"s"*(m==59)+ " to %s"%hour) 
 *
 */
public class TimeInWords {
	public static void main(String[] args) {
		System.out.println(timeInWords(1, 45));
	}

	// Complete the timeInWords function below.
	static String timeInWords(int h, int m) {
		String [] inWords = new String[] {
		"o'clock","one","two","three","four","five","six","seven","eight","nine","ten","eleven",
		"twelve","thirteen","fourteen","quarter","sixteen","seventeen","eighteen","nineteen",
		"twenty","twenty one","twenty two","twenty three","twenty four","twenty five","twenty six",
		"twenty seven","twenty eight","twenty nine","half"
		};
		StringBuilder result = new StringBuilder();
		if(m==0)
		{
		return result.append(inWords[h]+" o' clock").toString();
		}
		else
		{
			int val = (m<=30)? m: 60-m;
			System.out.println("val is :-"+val);
			result.append(inWords[val]+" ");
			if(val==1)result.append("minute ");
			else if(val != 15 && val != 30 ) {
				result.append("minutes ");
			}
			if(m<=30) {
				result.append("past ");
				result.append(inWords[h]);
			}
			else {
				result.append("to ");
				result.append(inWords[h+1]);
			}
			
		return result.toString();				
		}
	}
}
