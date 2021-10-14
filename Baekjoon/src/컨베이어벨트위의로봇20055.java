import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇20055 {

	static class Node {
		int A;
		boolean robot;
		
		public Node(int a, boolean robot) {
			super();
			A = a;
			this.robot = robot;
		}
	}
	
	static int N, K;
	// 빈 칸의 개수 cnt / 단계를 나타내는 level
	static int cnt, level;
	// 벨트를 이동시키기 위해 list 자료구조를 사용하였고,
	// 내구도와 로봇 여부를 클래스로 만들어서 넣었다.
	static ArrayList<Node> belt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 입력
		belt = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * N; i++) {
			int a = Integer.parseInt(st.nextToken());
			belt.add(new Node(a, false));
		}
		
		level = 0;
		solve();
		System.out.println(level);
	}

	private static void solve() {
		// 빈 칸이 K개가 될 때까지
		while(cnt < K) {
			// 1. 벨트 회전
			moveBelt();
			
			// 2. 로봇 옮기기
			moveRobots();
			
			// 3. 올리는 칸에 로봇 올리기
			onRobot();
			
			// 4. 빈 칸 개수 세기
			cntBlanks();
			level++;
		}
	}
	
	private static void moveBelt() {
		// 맨 마지막 노드를 떼서 맨 앞에 붙인다.
		Node last = belt.remove(2 * N - 1);
		belt.add(0, last);
		
		// 로봇은 내리는 위치에 도달하는 즉시 내려와야 하므로
		// 회전 후에 로봇을 내려준다.
		Node down = belt.get(N-1);
		if(down.robot) {
			down.robot = false;
		}
	}

	private static void moveRobots() {
		// 내리는 칸 - 1 부터 올리는 칸까지 로봇 검사
		for(int i = N - 2; i >= 0; i--) {
			Node curr = belt.get(i);
			Node next = belt.get(i+1);
			// 다음 칸에 로봇이 있거나 내구도가 0이라면 pass
			if(next.robot || next.A == 0) continue;

			// 현재 칸에 로봇이 있다면 다음 칸으로 옮겨주고
			if(curr.robot) {
				curr.robot = false;
				next.robot = true;
				next.A--;
			}
		}
		
		// 내리는 칸을 검사해서 로봇이 있다면 내려준다.
		Node down = belt.get(N-1);
		if(down.robot) {
			down.robot = false;
		}
	}

	private static void onRobot() {
		// 첫번째 칸의 내구도가 남아있다면 로봇을 올려주기!
		Node up = belt.get(0);
		if(up.A != 0) {
			up.robot = true;
			up.A--;
		}
	}

	private static void cntBlanks() {
		// 내구도가 0인 칸을 세서 cnt 변수에 갱신해준다.
		cnt = 0;
		for(Node b : belt) {
			if(b.A == 0) cnt++;
		}
	}

}
