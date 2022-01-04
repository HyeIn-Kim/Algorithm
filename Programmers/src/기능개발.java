import java.util.*;

// Queue에 넣을 정보를 담은 클래스
class Work {
    int progress;			// 일의 진행도
    int speed;				// 하루에 진행되는 일의 양
    
    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	// Queue에 일을 순차적으로 담아준다.
        Queue<Work> queue = new LinkedList<>();
        int size = progresses.length;
        for(int i = 0; i < size; i++) {
            queue.add(new Work(progresses[i], speeds[i]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            size = queue.size();
            // 오늘 배포되는 일 수
            int cnt = 0;
            
            // 하루마다
            for(int i = 0; i < size; i++) {
            	// 일을 진행시켜주고
                Work w = queue.poll();
                w.progress += w.speed;
                // 완료되지 않았으면 다시 큐에 넣음
                if(w.progress < 100) queue.offer(w);
                // 완료된 경우, 순차적으로 배포하고
                // 먼저 끝나더라도 앞 작업이 될 때까지 기다림 (큐에 넣음)
                else {
                    if(i != cnt) queue.offer(w);
                    else cnt++;
                }
            }
            
            // 배포된 일이 있을때마다 리스트 추가
            if(cnt != 0) list.add(cnt);
        }
        
        // 리스트 -> int 배열 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}