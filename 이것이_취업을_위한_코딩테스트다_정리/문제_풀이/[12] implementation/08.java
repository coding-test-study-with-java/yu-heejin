import java.io.*;
import java.util.*;

// CPU Time: 0.25 sec(s), Memory: 36656 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        List<Character> alpha = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                alpha.add(ch);
            } else {
                sum += (ch - '0');
            }
        }
        
        Collections.sort(alpha);
        
        StringBuilder sb = new StringBuilder();
        for (char ch : alpha) {
            sb.append(ch);
        }
        
        System.out.println(sb.toString() + sum);
    }
}