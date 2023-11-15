import java.util.*;
import java.io.*;
    
public class MyClass {
    public static void main(String args[]) throws IOException {
        long startTime = System.currentTimeMillis();
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
            
            if (a < b) {  // 해당 조건 반드시 추가
                A.set(i, b);
                B.set(i, a);
            } else {
                break;
                // A는 오름차순, B는 내림차순
                // 만약 A의 가장 작은 원소가 B의 가장 큰 원소보다 크면 더 볼 이유가 없음
            }
        }
        
        int sum = 0;
        
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);    
        }
        
        System.out.println(sum);
        
        long endTime = System.currentTimeMillis();

        System.out.println(String.format("코드 실행 시간: %20dms", endTime - startTime));
    }
}