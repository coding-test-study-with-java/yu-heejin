import java.util.*;

/**
 * 
 * 정확성  테스트
    테스트 1 〉	통과 (0.08ms, 74MB)
    테스트 2 〉	통과 (0.20ms, 79.9MB)
    테스트 3 〉	통과 (0.72ms, 77.8MB)
    테스트 4 〉	통과 (0.81ms, 84.1MB)
    테스트 5 〉	통과 (0.66ms, 80.8MB)
    테스트 6 〉	통과 (0.08ms, 77.4MB)
    테스트 7 〉	통과 (0.10ms, 77.5MB)
    테스트 8 〉	통과 (1.00ms, 85.8MB)
    테스트 9 〉	통과 (1.43ms, 72.7MB)
    테스트 10 〉	통과 (0.86ms, 80.4MB)
    테스트 11 〉	통과 (1.19ms, 74.3MB)
    테스트 12 〉	통과 (1.37ms, 75.6MB)
    테스트 13 〉	통과 (1.81ms, 81.2MB)
    테스트 14 〉	통과 (1.71ms, 66.3MB)
    테스트 15 〉	통과 (2.92ms, 77.3MB)
    
    효율성  테스트
    테스트 1 〉	통과 (8.45ms, 54.4MB)
    테스트 2 〉	통과 (12.53ms, 57.7MB)
    테스트 3 〉	통과 (16.51ms, 57.7MB)
    테스트 4 〉	통과 (17.31ms, 70.9MB)
    테스트 5 〉	통과 (25.92ms, 63.2MB)
    테스트 6 〉	통과 (32.00ms, 83.9MB)
    테스트 7 〉	통과 (35.86ms, 82.3MB)
    테스트 8 〉	통과 (57.85ms, 68.3MB)
    테스트 9 〉	통과 (34.23ms, 69.8MB)
    테스트 10 〉	통과 (43.68ms, 74.2MB)
    테스트 11 〉	통과 (77.34ms, 78.9MB)
    테스트 12 〉	통과 (31.81ms, 79.7MB)
    테스트 13 〉	통과 (53.51ms, 81.6MB)
    테스트 14 〉	통과 (53.99ms, 80.4MB)
    테스트 15 〉	통과 (70.01ms, 80.1MB)
    
    채점 결과
    정확성: 33.3
    효율성: 66.7
    합계: 100.0 / 100.0
 */

class Solution {
    
    // 효율성 문제는 O(n)의 효율성을 보여야한다.
    public int[] solution(String[] gems) {
        // 1. 보석 종류 저장하기
        Set<String> gemCategory = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemCategory.add(gems[i]);
        }
        
        int[] minSection = { 1, gems.length };
        Map<String, Integer> map = new HashMap<>();
        int start = 0;   // 시작 번호 고정
        int distance = minSection[1] - minSection[0];
        
        for (int end = 0; end < gems.length; end++) {
            // 구간별 보석 개수 카운트
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            // 만약 '시작' 위치에서 넣은 보석의 수가 1보다 많다면 (중복 보석)
            while (map.get(gems[start]) > 1) {
                // 시작 지점을 뒤로 땡기고 보석의 수를 1 감소한다.
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            // 보석을 모두 담았고 현재 구간의 거리가 더 작은 경우
            if (map.size() == gemCategory.size() && distance > ((end+1) - (start+1))) {
                distance = (end + 1) - (start + 1);
                minSection[0] = start + 1;
                minSection[1] = end + 1;
            }
        }
        
        return minSection;
    }
}