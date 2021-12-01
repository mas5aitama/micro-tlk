import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class arrayTests {

    public static void main(String[] args)
    {
        int []a = {1,-1,2,-2};
        printSumPairs(a,1);

    }

    public static void printSumPairs(int []input, int k){
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for(int i=0;i<input.length;i++){

            if(pairs.containsKey(input[i]))
                System.out.println(input[i] +", "+ pairs.get(input[i]));
            else
                pairs.put(k-input[i], input[i]);
        }
    }
}
