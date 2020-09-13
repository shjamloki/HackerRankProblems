package sqrt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SherlockAndSquare4 {
	/**
	 * sample input : 
	 * 2
	 *  3 9
	 * 17 24
	 * 
	 * Sample output: 
	 * 2
	 *  0
	 *  
	 * test - 2:
	 *   2
     *  35 70
     *  100 1000 
     *  
     * Sample output
     * 3
     * 22  
	 */
	private static final Scanner scanner = new Scanner(System.in);
	static Calendar calendar = Calendar.getInstance();
	// Complete the squares function below.
    static int squares(int a, int b) {
    	return ( int) IntStream.rangeClosed(a,b)
                .parallel()
                .mapToDouble(i->Math.sqrt(i))
                .filter(i ->(i-Math.floor(i)==0))
                .count(); 
         }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/sqrt/test.txt"));

        System.out.println("current path : "+ new File(".").getAbsolutePath());
        int lineNum[] = {0};
        long startDate = System.nanoTime();
        Files.lines(Paths.get("./src/sqrt/testcase5.txt")).forEach(i ->{
        	if(lineNum[0]==0)
        	{
        	 //ignore	
        	}
        	else
        	{
        	  int a = Integer.parseInt(i.split(" ")[0]);
        	  int b = Integer.parseInt(i.split(" ")[1]);
        	  int result = squares(a, b);
              
              try {
				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
		    } catch (IOException e) {
				e.printStackTrace();
			}
           }
        	lineNum[0]++;
        });
        long endDate = System.nanoTime();
        long exeTime = (endDate - startDate)/1000000;
        System.out.println("time taken in mili seconds : = "+exeTime);
        
        bufferedWriter.close();

        scanner.close();
    }
}
