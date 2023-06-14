import java.util.*;
import java.io.*;

// 오름차순이 아니라 내림차순임을 기억하라
// 퀵소트를 사용하여 정렬
// 코드 실행 시간:                   23ms
public class MyClass {
    private static void quickSort(ArrayList<Integer> numbers, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int pivot = start;
        int left = start + 1;
        int right = end;
        
        while (left <= right) {
            while (left <= end && numbers.get(left) >= numbers.get(pivot)) {
                left++;
            }
            
            while (right > start && numbers.get(right) < numbers.get(pivot)) {
                right--;
            }
            
            if (left > right) {
                int temp = numbers.get(pivot);
                numbers.set(pivot, numbers.get(right));
                numbers.set(right, temp);
            } else {
                int temp = numbers.get(left);
                numbers.set(left, numbers.get(right));
                numbers.set(right, temp);
            }
        }
        
        quickSort(numbers, start, right - 1);
        quickSort(numbers, right + 1, end);
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        
        System.out.println("before: " + numbers);
        
        quickSort(numbers, 0, n - 1);
        
        System.out.println("after: " + numbers);
    }
}