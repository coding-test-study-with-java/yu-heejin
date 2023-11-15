import java.util.*;
import java.io.*;

// CPU Time: 0.09 sec(s), Memory: 31848 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> fears = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
        
        while (token.hasMoreTokens()) {
            fears.add(Integer.parseInt(token.nextToken()));
        }
        
        Collections.sort(fears);
        
        int count = 0;
        int group = 0;
        for (int fear : fears) {
            count++;
            if (count >= fear) {
                group++;
                count = 0;
            }
        }
        
        System.out.println(group);
    }
}