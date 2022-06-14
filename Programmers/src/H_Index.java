import java.util.*;
class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        int n = citations.length;
        for(int i = 0; i < n; i++) {
            if(n - i <= citations[i]) {
                // 처음에 citations[i]로 해서 엄청 틀렸었는데
                // 인용수가 꼭 배열에 있는게 아니었다....!
                answer = n - i;
                break;
            }
        }

        return answer;
    }
}