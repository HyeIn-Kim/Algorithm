import java.util.*;
class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        int cnt = 0;
        while(pq.size() > 1) {
            if(pq.peek() >= K) return cnt;

            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + (b * 2));
            cnt++;
        }

        if(pq.peek() < K) return -1;
        else return cnt;
    }
}