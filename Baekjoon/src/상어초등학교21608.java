import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 상어초등학교21608 {

	static class Student {
		int n;
		int[] friends;
		
		public Student(int n, int[] friends) {
			super();
			this.n = n;
			this.friends = friends;
		}
	}
	
	static class Seat implements Comparable<Seat>{
		int r, c;
		int cntFriends;
		int cntBlanks;
		
		public Seat(int r, int c, int cntFriends, int cntBlanks) {
			super();
			this.r = r;
			this.c = c;
			this.cntFriends = cntFriends;
			this.cntBlanks = cntBlanks;
		}

		@Override
		public int compareTo(Seat o) {
			if(this.cntFriends == o.cntFriends) {
				if(this.cntBlanks == o.cntBlanks) {
					if(this.r == o.r) {
						return this.c - o.c;
					}
					else return this.r - o.r;
				}
				else return o.cntBlanks - this.cntBlanks;
			}
			else return o.cntFriends - this.cntFriends;
		}
	}
	
	static int N;
	static Student[] students;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static PriorityQueue<Seat> seats;
	static int scores;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 학생 입력
		students = new Student[N * N];
		for(int i = 0; i < (N * N); i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			students[i] = new Student(n, new int[4]);
			
			for(int j = 0; j < 4; j++) {
				students[i].friends[j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 학생 순서대로 좌석을 배치한다.
		map = new int[N+1][N+1];
		for(int i = 0; i < (N * N); i++) {
			chooseSeat(i);
		}
		
		// 만족도 조사
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				scores += cntScore(i, j);
			}
		}
		
		System.out.println(scores);
	}
	
	private static void chooseSeat(int idx) {
		// 상어가 앉을 수 있는 좌석들의 정보를 PQ에 저장.
		// 문제 조건에 따라서 반환된다.
		seats = new PriorityQueue<>();
		
		// 1. 현재 맵에서 빈칸을 찾는다
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 0) {
					seats.add(AddSeat(i, j, idx));
				}
			}
		}
		
		// 2. 조건에 맞는 자리에 상어를 배치한다.
		Seat s = seats.poll();
		map[s.r][s.c] = students[idx].n;
	}

	private static Seat AddSeat(int r, int c, int idx) {
		int cntFriends = 0;
		int cntBlanks = 0;
		
		// 인접한 칸을 탐색하며
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 밖이라면 pass
			if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
			
			// 빈 칸이라면 개수를 센다.
			if(map[nr][nc] == 0) cntBlanks++;
			
			// 이미 학생이 앉아 있다면
			else {
				for(int i = 0; i < 4; i++) {
					// 앉은 사람이 상어의 친구인지 확인하고 몇 명인지 센다.
					if(map[nr][nc] == students[idx].friends[i]) {
						cntFriends++;
					}
				}
			}
		}
		
		return new Seat(r, c, cntFriends, cntBlanks);
	}

	private static int cntScore(int r, int c) {
		int cntFriends = 0;
		
		// 배열에서 상어 위치를 찾는다 (리스트로 할걸..)
		int idx = 0;
		for(int i = 0; i < (N * N); i++) {
			if(students[i].n == map[r][c]) {
				idx = i;
				break;
			}
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 밖이라면 pass
			if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
			
			for(int i = 0; i < 4; i++) {
				// 앉은 사람이 상어의 친구인지 확인하고 몇 명인지 센다.
				if(map[nr][nc] == students[idx].friends[i]) {
					cntFriends++;
				}
			}
		}
		
		// 0, 1, 10, 100, 1000: 10의 지수로 커지므로 이렇게 반환해주었다.
		return (int) Math.pow(10, cntFriends-1);
	}
}
