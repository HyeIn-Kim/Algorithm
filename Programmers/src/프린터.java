import java.util.*;

// 백준 1966 프린터 큐랑 똑같은 문제였는데 다시 푸니까 까먹었다..
// 프린터 큐 풀때는 10칸짜리 priority 배열을 만들어서 풀었었는데
// 이번에는 priorities 배열을 정렬해서 풀었음. while문 안도 훨씬 깔끔해졌다!
class Document {
    int priority;		// 중요도
    int location;		// 문서 위치
    
    public Document(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

class 프린터 {
    public int solution(int[] priorities, int location) {
    	// 큐에 문서들을 담음
        Queue<Document> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }
        
        // 우선순위 정렬. 오름차순으로 정렬됨
        Arrays.sort(priorities);

        int size = priorities.length;
        int cnt = 1;						// 출력한 문서 개수
        while(!queue.isEmpty()) {
        	// 남은 문서 중 가장 높은 우선순위를 구하고
            int priority = priorities[size - cnt];
            // 해당 우선순위가 나올 때까지 큐를 움직임
            while(queue.peek().priority != priority) {
                queue.offer(queue.poll());
            }
            
            // 뽑은 뒤 자리를 비교하고 종료
            Document d = queue.poll();
            if(d.location == location) break;
            cnt++;
        }
        
        return cnt;
    }
}