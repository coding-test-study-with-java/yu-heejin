import java.util.*;

class Food implements Comparable<Food> {
    
    int time;
    int order;
    
    public Food(int time, int order) {
        this.time = time;
        this.order = order;
    }
    
    // 오름차순 정렬
    @Override
    public int compareTo(Food food) {
        return this.time - food.time;
    }
    
    @Override
    public String toString() {
        return time + "/" + order;
    }
}

class Solution {
    
    public int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }
        
        Collections.sort(foods);
        
        long prevTime = 0;
        int length = food_times.length;
        
        for (Food food : foods) {
            // 줄어들 음식량(시간) = 가장 적은 시간을 가지는 음식 - 이전에 먹은 음식
            long time = food.time - prevTime;
            
            if (time > 0) {  // 아직 시간이 남아있다면
                time *= length;   // 줄어들 시간 * 남은 음식 수
                
                if (time <= k) {  // 시간이 남았다면
                    k -= time;
                    prevTime = food.time;
                } else {
                    k %= length;
                    
                }
            }
            
            length--;
        }
        
        System.out.println(foods);
        
        return 0;
    }
}