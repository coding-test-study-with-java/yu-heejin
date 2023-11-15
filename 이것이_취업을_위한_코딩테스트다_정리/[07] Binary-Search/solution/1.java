import java.util.*;
import java.io.*;

// 코드 실행 시간:                    3ms

public class MyClass {
    private static final String[] RESULTS = { "yes", "no" };
    
    private static int binarySearch(List<Integer> arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (arr.get(mid) == target) {
                return mid;
            }
            
            if (arr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        String[] tempMyParts = reader.readLine().split(" ");
        
        int m = Integer.parseInt(reader.readLine());
        String[] tempNeededParts = reader.readLine().split(" ");
        
        List<Integer> myParts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            myParts.add(Integer.parseInt(tempMyParts[i]));
        }
        
        Collections.sort(myParts);   // 정렬하는거 까먹지말것!
        
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int result = binarySearch(myParts, Integer.parseInt(tempNeededParts[i]), 0, n - 1);
            
            if (result != -1) {
                results.add(RESULTS[0]);
            } else {
                results.add(RESULTS[1]);
            }
        }
        
        System.out.println(results);
    }
}