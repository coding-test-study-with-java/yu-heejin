import java.util.*;
import java.io.*;

public class MyClass {
    
    private static final List<String> VOWEL = Arrays.asList(new String[] { "a", "e", "i", "o", "u" });
    private static String[] input;
    private static int[] bucket;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        
        String[] alphabet = reader.readLine().split(" ");
        Arrays.sort(alphabet);
        
        bucket = new int[l];
        
        combination(alphabet, c, l);
    }
    
    private static void combination(String[] alphabet, int n, int r) {
        if (r == 0) {
            StringBuilder answer = new StringBuilder();
            int vowel = 0;
            
            for (int i = 0; i < bucket.length; i++) {
                if (VOWEL.contains(alphabet[bucket[i]])) {
                    vowel++;
                }
                answer.append(alphabet[bucket[i]]);
            }
            
            if (vowel >= 1) {
                System.out.println(answer);
            }

            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = 0;
        
        if (bucket.length > r) {
            smallest = bucket[lastIndex] + 1;
        }
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(alphabet, n, r - 1);
        }
    }
}