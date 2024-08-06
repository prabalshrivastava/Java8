package hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'efficientJanitor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts FLOAT_ARRAY weight as parameter.
     */

    public static int efficientJanitor(List<Float> weight) {
        // Map<Float,Integer> map = new TreeMap<Float,Integer>();
        // for(int i = 0; i< weight.size(); i++){
        //     map.put(weight.get(i), map.getOrDefault(weight.get(i),0) + 1);
        // }
        
        // for(int i = 0; i< weight.size(); i++){
            
        // }
        // for(Map.Entry<Float,Integer> entry : map.entrySet()){
            
        // }
        
        int i = 0;
        int j = weight.size() - 1;
        Float sum = 0.0f;
        int count = 0;
        weight.sort(Comparator.naturalOrder());
        while(i < j){
          if (weight.get(j) > 3.0) {
            continue;
          }
            if(weight.get(j) == 3.0){
                j--;
                count++;
                continue;
            }
            if(3.0 - weight.get(j) < weight.get(i)){
                j--;
                count++;
                continue;
            }
            count++;
            i++;
            j--;
        }
        return count;
    }

}

public class EfficientJanitor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> weight = IntStream.range(0, weightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Float::parseFloat)
            .collect(toList());

        int result = Result.efficientJanitor(weight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
