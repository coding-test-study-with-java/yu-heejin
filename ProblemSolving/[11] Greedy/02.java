import java.util.*;
import java.io.*;

// CPU Time: 0.11 sec(s), Memory: 31984 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String numbers = reader.readLine();
        int result = 0;
        
        for (int i = 0; i < numbers.length(); i++) {
            int number = numbers.charAt(i) - '0';
            
            if (result <= 1 || number <= 1) {
                result += number;
            } else {
                result *= number;
            }
        }
        
        System.out.println(result);
    }
}