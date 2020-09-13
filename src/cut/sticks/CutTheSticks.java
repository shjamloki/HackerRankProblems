package cut.sticks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    	
      // 2nd attempt: 
    	List<Integer> result = new ArrayList<>();
     // when we need regular min or max. It is always good to sort.
      Arrays.parallelSort(arr);	
      //System.out.println(arr.length);
      result.add(arr.length);
      for (int i = 1; i < arr.length; i++) {
          if (arr[i] != arr[i-1]) {
              //System.out.println(arr.length - i);
        	  result.add(arr.length-i);
          }
      }
      return result.stream().mapToInt(i->i).toArray();
      /*
       * 1st attempt : many mistakes 	
       */
     /* List<Integer> result = new ArrayList<>();
      List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
      int n = numbers.size();
      while(n >0)
      {
          result.add(n);
          int min = numbers.stream().filter(i -> i != 0).min(Integer::compare).get();
          for(int j =0; j<numbers.size(); j++)
          {
             if(numbers.get(j) == 0)
              {
                // continue;
              }
              else
              {
                  numbers.set(j,numbers.get(j) -min);
              }
          } 
        n = (int)numbers.stream().filter(i-> (i!=0)).count();
      }
      return result.stream().mapToInt(i->i).toArray(); */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     /*   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/cut/sticks/testout.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); */
    	
    	int[] result = cutTheSticks(new int[] {5,4,4,2,2,8});
    	System.out.println(Arrays.toString(result));
    	
    }
}

