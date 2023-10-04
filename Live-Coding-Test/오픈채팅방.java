import java.util.*;

/**
 * 테스트 1 〉	통과 (2.27ms, 73.3MB)
테스트 2 〉	통과 (2.35ms, 78.2MB)
테스트 3 〉	통과 (2.51ms, 74.8MB)
테스트 4 〉	통과 (2.39ms, 72.2MB)
테스트 5 〉	통과 (5.33ms, 76.5MB)
테스트 6 〉	통과 (7.28ms, 86.6MB)
테스트 7 〉	통과 (5.22ms, 75.7MB)
테스트 8 〉	통과 (6.34ms, 79.9MB)
테스트 9 〉	통과 (6.56ms, 83.6MB)
테스트 10 〉	통과 (5.50ms, 75.4MB)
테스트 11 〉	통과 (4.93ms, 74.7MB)
테스트 12 〉	통과 (5.14ms, 83.1MB)
테스트 13 〉	통과 (11.15ms, 94.5MB)
테스트 14 〉	통과 (5.44ms, 82.3MB)
테스트 15 〉	통과 (2.56ms, 78.3MB)
테스트 16 〉	통과 (2.20ms, 70.9MB)
테스트 17 〉	통과 (2.83ms, 78.1MB)
테스트 18 〉	통과 (3.30ms, 76.2MB)
테스트 19 〉	통과 (10.51ms, 91.5MB)
테스트 20 〉	통과 (6.26ms, 84.2MB)
테스트 21 〉	통과 (6.20ms, 79.3MB)
테스트 22 〉	통과 (7.52ms, 81.7MB)
테스트 23 〉	통과 (6.65ms, 78.1MB)
테스트 24 〉	통과 (7.88ms, 80.9MB)
테스트 25 〉	통과 (110.20ms, 180MB)
테스트 26 〉	통과 (128.57ms, 152MB)
테스트 27 〉	통과 (134.67ms, 164MB)
테스트 28 〉	통과 (122.13ms, 186MB)
테스트 29 〉	통과 (133.87ms, 160MB)
테스트 30 〉	통과 (157.46ms, 166MB)
테스트 31 〉	통과 (193.28ms, 157MB)
테스트 32 〉	통과 (96.50ms, 142MB)
 */
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idAndNickname = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] token = record[i].split(" ");
            if (token[0].equals("Enter") || token[0].equals("Change")) {
                idAndNickname.put(token[1], token[2]);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            String[] token = record[i].split(" ");
            if (token[0].equals("Enter")) {
                String nickname = idAndNickname.get(token[1]);
                answer.add(nickname + "님이 들어왔습니다.");
            }
            
            if (token[0].equals("Leave")) {
                String nickname = idAndNickname.get(token[1]);
                answer.add(nickname + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}