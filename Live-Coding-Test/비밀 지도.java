import java.util.*;

/**
 * 
 * 테스트 1 〉	통과 (9.53ms, 83.9MB)
    테스트 2 〉	통과 (11.78ms, 78MB)
    테스트 3 〉	통과 (10.77ms, 68.6MB)
    테스트 4 〉	통과 (9.92ms, 83MB)
    테스트 5 〉	통과 (9.08ms, 76.2MB)
    테스트 6 〉	통과 (9.10ms, 79MB)
    테스트 7 〉	통과 (7.33ms, 77.8MB)
    테스트 8 〉	통과 (9.77ms, 74.2MB)
 */

class Solution {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 각 배열 정수 배열 이진수로 변환
        String[] arr1Map = new String[n];
        String[] arr2Map = new String[n];
        
        for (int i = 0; i < n; i++) {
            String arr1Result = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i])));
            String arr2Result = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[i])));
            
            arr1Map[i] = arr1Result;
            arr2Map[i] = arr2Result;
        }
        
        String[] answers = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                char a1 = arr1Map[i].charAt(j);
                char a2 = arr2Map[i].charAt(j);
                
                if (a1 == '0' && a2 == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            
            answers[i] = sb.toString();
        }
        
        return answers;
    }
}