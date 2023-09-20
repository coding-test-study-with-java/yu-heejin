import java.util.*;

/**
 * 테스트 1 〉	통과 (0.07ms, 74.8MB)
    테스트 2 〉	통과 (0.08ms, 75.4MB)
    테스트 3 〉	통과 (0.07ms, 71.9MB)
    테스트 4 〉	통과 (0.09ms, 79.5MB)
    테스트 5 〉	통과 (0.15ms, 73.7MB)
    테스트 6 〉	통과 (0.10ms, 65.5MB)
    테스트 7 〉	통과 (0.13ms, 73.2MB)
    테스트 8 〉	통과 (0.18ms, 77.8MB)
    테스트 9 〉	통과 (0.22ms, 72.6MB)
    테스트 10 〉	통과 (0.19ms, 71.4MB)
    테스트 11 〉	통과 (0.15ms, 75.5MB)
    테스트 12 〉	통과 (0.15ms, 73.2MB)
    테스트 13 〉	통과 (0.24ms, 75.5MB)
    테스트 14 〉	통과 (10.72ms, 83.4MB)
    테스트 15 〉	통과 (11.13ms, 74.3MB)
    테스트 16 〉	통과 (7.61ms, 69.2MB)
    테스트 17 〉	통과 (0.74ms, 75.3MB)
    테스트 18 〉	통과 (0.82ms, 76.5MB)
    테스트 19 〉	통과 (0.37ms, 78.9MB)
    테스트 20 〉	통과 (0.78ms, 78.5MB)
    테스트 21 〉	통과 (2.93ms, 79.5MB)
    테스트 22 〉	통과 (1.30ms, 76.2MB)
    테스트 23 〉	통과 (3.66ms, 79MB)
    테스트 24 〉	통과 (3.78ms, 76.9MB)
    테스트 25 〉	통과 (2.91ms, 76.4MB)
    테스트 26 〉	통과 (1.75ms, 71.9MB)
 */

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        int start = 0;
        int order = 1;
        int answerCount = 0;
        StringBuilder sb = new StringBuilder();
        
        while (answerCount < t) {
            String convert = Integer.toString(start, n);
            for (int i = 0; i < convert.length(); i++) {
                if (order == p && answerCount < t) {
                    sb.append(convert.charAt(i));
                    answerCount++;
                }
                
                order++;
                if (order > m) {
                    order = 1;
                }
            }
            
            start++;
        }
        
        return sb.toString().toUpperCase();
    }
}