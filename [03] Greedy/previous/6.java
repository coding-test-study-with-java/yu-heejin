import java.util.*;

// code reference from https://dev-note-97.tistory.com/248
// https://programmer-chocho.tistory.com/71
// 빠른 접근을 위해 캡슐화 X
// 미완성 ㅜㅜ
class Food implements Comparable<Food> {
    int time;
    int order;
    
    public Food(int time, int order) {
        this.time = time;
        this.order = order;
    }
    
    @Override
    public int compareTo(Food food){
        return this.time - food.time;
    }
    
    @Override
    public String toString() {
        return time + " and " + order;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<>();
        
        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i+1));
        }
        
        Collections.sort(foods);
        
        if (foods.get(0).time > k) return 1;
        
        long preTime = 0;  // 이전에 걸린 시간
        int foodCount = foods.size();  // 남은 음식
        for (int i = 0; i < foods.size(); i++) {
            long diffTime = foods.get(i).time - preTime;
            if (diffTime > 0) {
                long cost = diffTime * foods.size;
                
                if (k - cost >= 0) {
                    k -= cost;
                    preTime = foods.get(i).time;
                } else {
                    k = k % foodCount;
                    food.subList(i, food_times.length).sort((Food f1, food f2) => {
                        return f1.order - f2.order;
                    });
                }
            }
        }
        
        return -1;
    }
}