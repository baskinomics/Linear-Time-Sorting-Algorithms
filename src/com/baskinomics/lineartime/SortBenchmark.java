import java.util.Random;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 *
 */
public class SortBenchmark {
    /**
     *
     */
    public static void main(String[] args) {
        ArrayList<int[]> randomArrays = new ArrayList<int[]>(10000);

        for (int i = 0; i < 10000; i++) {
            randomArrays.add(i, createRandomArray(i+1));
        }

        try {
            FileWriter writer = new FileWriter("sorting-results.csv");

            writer.append("algorithm,n,duration\n");

            for (int n = 1; n <= 10000; n++) {
                int[] randomArray = randomArrays.get(n-1);
                int k = LinearTimeSort.getMax(randomArray);
                
                String output = "countingsort,";
                long startTime = System.nanoTime();
                int[] countingSort = LinearTimeSort.countingSort(randomArray, k);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                output = output + Integer.toString(n) + "," + Long.toString(duration);
        
                // Write line
                writer.append(output + "\n");
                System.out.println(output);
            }

            for (int n = 1; n <= 10000; n++) {
                //System.out.println("Iteration: " + n);

                int[] randomArray = randomArrays.get(n-1);
                int k = LinearTimeSort.getMax(randomArray);
                
                String output = "radixsort,";
                long startTime = System.nanoTime();
                int[] radixSort = LinearTimeSort.radixSort(randomArray, k);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                output = output + Integer.toString(n) + "," + Long.toString(duration);
        
                // Write line
                writer.append(output + "\n");
                writer.flush();
                System.out.println(output);
            }

            for (int n = 1; n <= 10000; n++) {
                //System.out.println("Iteration: " + n);

                int[] randomArray = randomArrays.get(n-1);
                int k = LinearTimeSort.getMax(randomArray);
                
                String output = "bucketsort,";
                long startTime = System.nanoTime();
                int[] bucketSort = LinearTimeSort.bucketSort(randomArray, k);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                output = output + Integer.toString(n) + "," + Double.toString(duration);
        
                // Write line
                writer.append(output + "\n");
                System.out.println(output);
            }
            writer.close();
            //
        } catch(IOException e) {
            e.printStackTrace();
        } 

        try {
            FileWriter writer = new FileWriter("sorting-results-2.csv");

            writer.append("algorithm,n,seconds\n");

            for (int n = 1; n <= 10000; n++) {
                //System.out.println("Iteration: " + n);

                int[] randomArray = randomArrays.get(n-1);
                int k = LinearTimeSort.getMax(randomArray);
                
                String output = "bucketsort,";
                long startTime = System.nanoTime();
                int[] bucketSort = LinearTimeSort.bucketSort(randomArray, k);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                double seconds = (double) duration / 1000000000.0;
                output = output + Integer.toString(n) + "," + Double.toString(seconds);
        
                // Write line
                writer.append(output + "\n");
                System.out.println(output);
            }
            //
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] createRandomArray(int n) {
        Random r = new Random();
        int low = 1;
        int high = 1000;
        int[] randomArray = new int[n];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = r.nextInt(high-low) + low;
        }

        return randomArray;
    }
}