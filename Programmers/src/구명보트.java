import java.util.*;
class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int length = people.length;
        boolean[] survived = new boolean[length];
        int left = 0;
        int right = length - 1;

        while(left < right) {
            if(people[left] + people[right] > limit) {
                right--;
                continue;
            }

            survived[left] = true;
            survived[right] = true;
            answer++;
            left++;
            right--;
        }

        for(int i = 0; i < length; i++) {
            if(!survived[i]) answer++;
        }

        return answer;
    }
}