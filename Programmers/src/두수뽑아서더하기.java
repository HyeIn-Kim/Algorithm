import java.util.*;
class 두수뽑아서더하기 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(i == j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }


        int[] answer = new int[set.size()];
        int idx = 0;
        for(Integer i : set) {
            answer[idx++] = i;
        }
        return answer;
    }
}