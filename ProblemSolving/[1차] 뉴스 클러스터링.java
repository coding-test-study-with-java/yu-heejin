import java.util.*;

/**
 * 테스트 1 〉	통과 (0.66ms, 72.3MB)
    테스트 2 〉	통과 (0.76ms, 76.4MB)
    테스트 3 〉	통과 (0.63ms, 75.5MB)
    테스트 4 〉	통과 (16.53ms, 80.1MB)
    테스트 5 〉	통과 (2.09ms, 66MB)
    테스트 6 〉	통과 (0.04ms, 73.6MB)
    테스트 7 〉	통과 (3.35ms, 65.5MB)
    테스트 8 〉	통과 (0.78ms, 75MB)
    테스트 9 〉	통과 (4.46ms, 75.4MB)
    테스트 10 〉	통과 (6.92ms, 78.4MB)
    테스트 11 〉	통과 (9.03ms, 76MB)
    테스트 12 〉	통과 (0.03ms, 70.9MB)
    테스트 13 〉	통과 (1.52ms, 76.8MB)
 */

class Solution {
    
    // 1. 문자열은 두 글자씩 끊어야한다.
    // 2. 특수문자는 제거한다.
    // 3. 합집합은 max, 교집합은 min
    public int solution(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return 65536;
        }
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        if (str1.equals(str2)) {
            return 65536;
        }
        
        List<String> split1Result = new ArrayList<>();
        List<String> split2Result = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.substring(i, i + 2).matches("[a-zA-Z]+")) {
                split1Result.add(str1.substring(i, i + 2));
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.substring(i, i + 2).matches("[a-zA-Z]+")) {
                split2Result.add(str2.substring(i, i + 2));
            }
        }
        
        // 다중집합의 교집합과 합집합
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        
        Collections.sort(split1Result);
        Collections.sort(split2Result);

        // 합집합
        // 두 중복되는 요소를 삭제하고 교집합에 넣는다.
        // 모든 요소를 합집합에 넣는다.
        for(String s : split1Result) {
            if(split2Result.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        // 교집합
        // 삭제된 요소를 제외하고 합집합에 넣는다. (교집합 제외)
        for(String s : split2Result) {
            union.add(s);
        }
        
        return (int)(((double) intersection.size() / union.size()) * 65536);
    }
}