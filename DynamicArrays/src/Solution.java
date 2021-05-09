import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
           

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

    int lastAnswer = 0;
    List<Integer> arr[] = new List[n];
    for (int i = 0; i<n; i++){
        arr[i] = new ArrayList<Integer>();
    }
    List<Integer> answers = new ArrayList<>();
    // List<List<Integer>> arr = new ArrayList<>();

    int idx, x, y, queryType;    
    
    
    // Write your code here
    for (List<Integer> query : queries){
        x = query.get(1);
        y = query.get(2);
        queryType = query.get(0);
        idx = (x^lastAnswer)%n;
        if (queryType==1){            
            arr[idx].add(y);
        }
        else if(queryType==2){
            lastAnswer = arr[idx].get((y%(arr[idx].size())));
             
            answers.add(lastAnswer);
        }

        }
        return answers;

    }
}


    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    
            int n = Integer.parseInt(firstMultipleInput[0]);
    
            int q = Integer.parseInt(firstMultipleInput[1]);
    
            List<List<Integer>> queries = new ArrayList<>();
    
            IntStream.range(0, q).forEach(i -> {
                try {
                    queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
    
            List<Integer> result = Result.dynamicArray(n, queries);
    
            bufferedWriter.write(
                result.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                + "\n"
            );
    
            bufferedReader.close();
            bufferedWriter.close();
        }
    }
    

