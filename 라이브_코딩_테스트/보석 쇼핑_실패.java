import java.util.*;

/**
 * 정확성  테스트
    테스트 1 〉	통과 (0.46ms, 72.6MB)
    테스트 2 〉	통과 (6.88ms, 80.9MB)
    테스트 3 〉	통과 (42.45ms, 80.1MB)
    테스트 4 〉	통과 (40.40ms, 95.8MB)
    테스트 5 〉	통과 (57.48ms, 92.8MB)
    테스트 6 〉	통과 (0.25ms, 72.9MB)
    테스트 7 〉	통과 (0.28ms, 73.8MB)
    테스트 8 〉	통과 (152.74ms, 83.5MB)
    테스트 9 〉	통과 (284.31ms, 79.6MB)
    테스트 10 〉	통과 (69.18ms, 92.7MB)
    테스트 11 〉	통과 (99.28ms, 92.6MB)
    테스트 12 〉	통과 (854.93ms, 111MB)
    테스트 13 〉	통과 (1581.77ms, 123MB)
    테스트 14 〉	통과 (230.25ms, 110MB)
    테스트 15 〉	통과 (8638.44ms, 274MB)

    효율성  테스트
    테스트 1 〉	실패 (시간 초과)
    테스트 2 〉	실패 (시간 초과)
    테스트 3 〉	실패 (시간 초과)
    테스트 4 〉	실패 (시간 초과)
    테스트 5 〉	실패 (시간 초과)
    테스트 6 〉	실패 (시간 초과)
    테스트 7 〉	실패 (시간 초과)
    테스트 8 〉	실패 (시간 초과)
    테스트 9 〉	실패 (시간 초과)
    테스트 10 〉	실패 (시간 초과)
    테스트 11 〉	실패 (시간 초과)
    테스트 12 〉	실패 (시간 초과)
    테스트 13 〉	실패 (시간 초과)
    테스트 14 〉	실패 (시간 초과)
    테스트 15 〉	실패 (시간 초과)
    
    채점 결과
    정확성: 33.3
    효율성: 0.0
    합계: 33.3 / 100.0
 */

class Solution {
    
    public int[] solution(String[] gems) {
        // 1. 보석 종류 저장하기
        Set<String> gemCategory = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemCategory.add(gems[i]);
        }
        
        // 2. 투 포인터 알고리즘
        int[] minSection = {1, gems.length};
        
        for (int start = 0; start < gems.length; start++) {
            Set<String> temp = new HashSet<>();
            temp.add(gems[start]);
            for (int end = start; end < gems.length; end++) {
                temp.add(gems[end]);
                
                if (temp.equals(gemCategory)) {
                    int min = minSection[1] - minSection[0];
                    int tempMin = (end + 1) - (start + 1);
                    
                    if (min > tempMin) {
                        minSection[0] = start + 1;
                        minSection[1] = end + 1;
                        break;
                    }
                }
            }
        }
        
        return minSection;
    }
}