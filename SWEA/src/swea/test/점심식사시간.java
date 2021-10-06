package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점심식사시간 {

	static class Point {
		int r;
		int c;
		int k;			// 계단에서만 쓰임. Stair 클래스를 하나 더만들어서 상속받는게 더 나았을 것 같다.
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	
	static int N, P, S;
	static ArrayList<Point> people;
	static ArrayList<Point> stairs;
	static boolean[] selected;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			// 입력
			// 맵을 다 저장하지 않고, 사람과 계단의 좌표만 골라서 ArrayList에 저장하였다.
			N = Integer.parseInt(br.readLine());
			people = new ArrayList<>();
			stairs = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 1) people.add(new Point(i, j));
					else if(input > 1) stairs.add(new Point(i, j, input));
				}
			}
			
			P = people.size();
			S = stairs.size();
			result = Integer.MAX_VALUE;
			selected = new boolean[P];
			// 계단은 맵에 2개밖에 없으니까 true / false로 구분해서
			// 부분집합으로 짰다!
			powerSet(0);
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

	private static void powerSet(int idx) {
		// 부분집합이 만들어지면
		if(idx == P) {
			// 걸리는 시간 중 최소값을 결과에 갱신
			result = Math.min(getTime(), result);
			return;
		}
		
		// 부분집합 코드
		selected[idx] = true;
		powerSet(idx + 1);
		selected[idx] = false;
		powerSet(idx + 1);
	}

	// 모든 사람이 계단을 다 내려가는 데에 걸리는 시간을 반환하는 함수 getTime.
	// 계단이 2개라 똑같은 코드가 변수명만 다르게 2번 반복되는데
	// 매개변수로 넘겼으면 더 좋지 않았을까?
	private static int getTime() {
		// 사람들을 계단별로 분리하기 위해 PQ 2개를 만들어 주었다.
		// 가장 적게 걸리는 시간부터 꺼내려고 PQ를 사용했다.
		PriorityQueue<Integer> stairA = new PriorityQueue<>();
		PriorityQueue<Integer> stairB = new PriorityQueue<>();
		for(int i = 0; i < P; i++) {
			// 선택되어 있다면 A계단으로, 선택되지 않았다면 B계단으로
			if(selected[i]) stairA.offer(getDistance(people.get(i), stairs.get(0)));					
			else stairB.offer(getDistance(people.get(i), stairs.get(1)));
		}
		
		// 계단을 내려가는 큐를 만들어서
		Queue<Integer> queueA = new LinkedList<>();
		while(!stairA.isEmpty()) {
			// 적은 순서대로 한명씩 뽑고
			int time = stairA.poll();
			// 계단에 3명보다 적게 있다면 그대로 삽입해준다.
			if(queueA.size() < 3) {
				queueA.offer(time + stairs.get(0).k + 1);
			}
			// 만약 계단에 3명 꽉 찼다면
			else if(queueA.size() == 3) {
				int prev = queueA.poll();
				// 시간이 겹치지 않을 때는 그대로 삽입하고
				if(prev <= time) queueA.offer(time + stairs.get(0).k + 1);
				// 시간이 겹친다면 이전 사람이 계단을 내려갈때까지 기다린다.
				else queueA.offer(prev + stairs.get(0).k);
			}
		}
		
		// A계단의 총 시간을 구한다.
		int cntA = 0;
		while(!queueA.isEmpty()) {
			int size = queueA.size();
			int time = queueA.poll();
			// 큐의 가장 마지막 원소가 걸리는 시간 = A계단 최종 시간
			if(size == 1) {
				cntA = time;
			}
		}
		
		// B계단도 A계단과 마찬가지로 시간을 구해준다.
		Queue<Integer> queueB = new LinkedList<>();
		while(!stairB.isEmpty()) {
			int time = stairB.poll();
			if(queueB.size() < 3) {
				queueB.offer(time + stairs.get(1).k + 1);
			}
			else if(queueB.size() == 3) {
				int prev = queueB.poll();
				if(prev <= time) queueB.offer(time + stairs.get(1).k + 1);
				else queueB.offer(prev + stairs.get(1).k);
			}
		}
		
		int cntB = 0;
		while(!queueB.isEmpty()) {
			int size = queueB.size();
			int time = queueB.poll();
			if(size == 1) {
				cntB = time;
			}
		}
		
		// A, B 계단 중 더 오래 걸리는 시간을 결과값으로 반환한다.
		return Math.max(cntA, cntB);
	}
	
	// 사람과 계단 사이의 거리를 구하는 함수
	private static int getDistance(Point A, Point B) {
		return Math.abs(A.r - B.r) + Math.abs(A.c - B.c);
	}

}
