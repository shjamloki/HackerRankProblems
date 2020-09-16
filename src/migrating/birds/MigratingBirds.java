package migrating.birds;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MigratingBirds {

	public static void main(String[] args) {
		Integer [] birdsPopulation = new Integer[] {1,2,3,4,5,4,3,2,1,3,4};
		System.out.println(migratoryBirds(Arrays.asList(birdsPopulation)));
	}

	static int migratoryBirds(List<Integer> arr) {
		return arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .findFirst()
                .get()
                .getKey();
	   /*	long [] population = new long[5];
		IntStream.rangeClosed(1,5).forEach(i->{
		 population[i-1] =arr.parallelStream().filter(j-> j==i).count();
		});
		long maxpopulation =0;
		int maxPopulationType=0;
		for (int i=0;i< population.length;i++) {
			if(population[i] > maxpopulation)
			{
				maxpopulation = population[i];
				maxPopulationType = i+1; 
			}
			else if(population[i] == maxpopulation)
			{
				maxPopulationType = (maxPopulationType > i+1) ? i+1: maxPopulationType;
			}
		}
		return maxPopulationType; */
	}

}
