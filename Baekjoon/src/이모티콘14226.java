import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘14226 {

	// 큐에 넣을 클래스
	static class Node {
		int n;				// 현재 화면에 몇 개 있는지
		int cnt;			// 몇 초 걸렸는지
		int clipBoard;		// 현재 클립보드에 몇 개 들어있는지
		
		public Node(int n, int cnt, int clipBoard) {
			super();
			this.n = n;
			this.cnt = cnt;
			this.clipBoard = clipBoard;
		}
	}
	
	static int S;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];		// 방문 배열. 이모티콘 X 클립보드
		
		// 최소 시간을 구하는 문제이므로 BFS로 접근했다.
		// 큐에 화면 1개 X 클립보드 0개를 넣고 시작! 
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0, 0));
		visited[1][0] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			// 만약 화면에 S개의 이모티콘이 있다면
			// 지금까지의 시간을 출력하고 종료
			if(n.n == S) {
				System.out.println(n.cnt);
				return;
			}
			
			// 1. 클립보드에 이모티콘 복사
			if(!visited[n.n][n.n]) {
				// 갯수는 그대로, 시간은 1, 클립보드를 화면의 이모티콘 개수로 변경함
				queue.offer(new Node(n.n, n.cnt + 1, n.n));
				visited[n.n][n.n] = true;
			}
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
			// 클립보드가 비어있지 않고 / 입력할 이모티콘이 S 최대인 1000개를 넘지 않으며 / 방문하지 않았을 때만
			if(n.clipBoard != 0 && n.n + n.clipBoard < 1001 && !visited[n.n][n.n + n.clipBoard]) {
				queue.offer(new Node(n.n + n.clipBoard, n.cnt + 1, n.clipBoard));
				visited[n.n][n.n + n.clipBoard] = true;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제
			// 이모티콘은 최소 0개 (음수가 될 수 없음) / 방문하지 않았을 때만
			if(n.n > 0 && !visited[n.n - 1][n.clipBoard]) {
				queue.offer(new Node(n.n - 1, n.cnt + 1, n.clipBoard));	
				visited[n.n - 1][n.clipBoard] = true;
			}
		}
	}

}
