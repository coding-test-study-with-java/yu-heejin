import java.util.*;
import java.io.*;

// 코드 실행 시간:                    3ms

public class MyClass {
    private static int binarySearch(List<Integer> arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) > mid) {
                    sum += arr.get(i) - mid;    
                }
            }
            
            if (sum == target) {
                return mid;
            }
            
            if (sum > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer numbers = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(numbers.nextToken());
        int m = Integer.parseInt(numbers.nextToken());
        
        StringTokenizer tempRiceCakes = new StringTokenizer(reader.readLine());
        List<Integer> riceCakes = new ArrayList<>();
        
        while (tempRiceCakes.hasMoreTokens()) {
            riceCakes.add(Integer.parseInt(tempRiceCakes.nextToken()));
        }
        
        System.out.println(binarySearch(riceCakes, m, 0, Collections.max(riceCakes)));
    }
}