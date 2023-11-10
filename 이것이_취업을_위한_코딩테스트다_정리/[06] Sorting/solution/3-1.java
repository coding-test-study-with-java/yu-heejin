import java.util.*;
import java.io.*;

// 코드 실행 시간:                    4ms
    
public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        String[] aScores = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(aScores[i]));
        }
        
        String[] bScores = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            B.add(Integer.parseInt(bScores[i]));
        }
        
        Collections.sort(A);
        Collections.sort(B, Comparator.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            int a = A.get(i);
            int b = B.get(i);
            
            A.set(i, b);
            B.set(i, a);
        }
        
        int sum = 0;
        
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);    
        }
        
        System.out.println(sum);
    }
}