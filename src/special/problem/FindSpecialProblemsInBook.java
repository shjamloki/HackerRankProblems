package special.problem;

import java.util.stream.IntStream;

/**
 *n,k = [int(x) for x in input().strip().split()]
 *problems_in_chapters = [int(x) for x in input().strip().split()]
 *count = 0
 *page = 1
 *for chapter_problem in problems_in_chapters:
 *  for current_problem in range(1,chapter_problem + 1):
 *        if(page == current_problem):
 *                count = count + 1
 *        if ((current_problem % k == 0 )or current_problem == chapter_problem):
 *                page = page + 1
 *                        
 * print(count) 
 *
 */
public class FindSpecialProblemsInBook {
	public static void main(String[] args) {
		System.out.println(workbook2(5, 3, new int[] { 4, 2, 6, 1, 10 }));
	}
	
	static int workbook2(int n, int k, int[] arr) {
	    int page=1,page_no=1,count=0;
	    for(int i=0;i<n;i++)
	    {
	        for(int j=1;j<=arr[i];j++) 
	        {
	            page=(j-1)/k+page_no;
	            if(page==j)
	                count++;
	        }
	        page++;
	        page_no=page;
	    }
	    return count;
	}

//Complete the workbook function below.
	static int workbook(int n, int k, int[] arr) {
		int[] pageNum = new int[] {1};
		int specialCount =0;
		for (int i = 1; i <= n; i++)// n=5, k=3
		{ // i =1,2,3
			int problems = arr[i - 1]; // 4,2,6
			for (int t = 0; t < problems;) { // t =0,3
				if (hasMoreKs(problems, t, k)) { // 4%t+k= 3=1
					if (IntStream.rangeClosed(t + 1, t + k).filter(p -> p == pageNum[0]).count() == 1)// 1-3 matched
					{
						specialCount++; // 1
					}
					pageNum[0]++;// 2
					t += k;// 3
				} else {
					if (IntStream.rangeClosed(t + 1, problems).filter(p -> p == pageNum[0]).count() == 1)//4-4notmatched
																											
					{
						specialCount++;
					}
					pageNum[0]++;//3,4
					break;
				}
			}
		}
		return specialCount;
	}
	
	public static boolean hasMoreKs(int problems,int t,int k)
	{
		return (problems/(t+k)>0);
	}
}
