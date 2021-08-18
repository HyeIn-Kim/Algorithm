import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 개선 1에서 시간 초과가 나길래
// ArrayList 대신 TreeSet을 사용한 버전 2.
// 결과는 역시나 시간 초과.
// 친구들과 얘기해 본 결과 while문 대신 특정 로직이 있는 것 같음..
// 새로운 자료구조 TreeSet의 사용법을 배웠다!
public class 돌던지기_개선2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		// 장애물(X)과 돌(O), 맵 끝 위치를 저장할 Set
		TreeSet<Integer>[] set = new TreeSet[C];
		
		for(int i = 0; i < C; i++) {
			set[i] = new TreeSet<>();
		}
		
		// map을 입력받는 부분
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				// 장애물이거나 맵 끝일 때 Set에 현재 r 위치 추가
				if(map[i][j] == 'X' || i == R-1) set[j].add(i);
			}
			
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			// 돌의 시작점을 설정함.
			int r = 0;
			int c = input - 1;
			while(true) {
				// 왼쪽, 오른쪽 다 막혀있을 경우를 판단할 변수
				boolean isStop = false;
				
				// O, X, 맵 끝 중 하나를 만날 때까지 돌을 아래로 떨어뜨림.
				r = set[c].higher(r);
				
				// 돌이 맵의 맨 끝까지 도달했을 경우 종료한다.
				if(r == R - 1 && map[r][c] == '.') {
					map[r][c] = 'O';
					set[c].add(r);
					break;
				}
				
				// X를 만나면 돌을 그자리에 고정시키고 종료
				if(map[r][c] == 'X') {
					map[r-1][c] = 'O';
					set[c].add(r-1);
					break;
				}
				
				// O를 만나면
				else if(map[r][c] == 'O') {
					r--;
					
					// 왼쪽, 왼쪽 아래를 검사
					if(c > 0 && r < R - 1) {
						if(map[r][c-1] == '.' && map[r+1][c-1] == '.') {
							c--;
							continue;
						}
					}
					
					// 오른쪽, 오른쪽 아래를 검사
					if(c < C - 1 && r < R - 1) {
						if(map[r][c+1] == '.' && map[r+1][c+1] == '.') {
							c++;
						}
						// 왼쪽, 오른쪽을 다 검사했지만 이동할 수 없는 경우
						// 이곳에서 돌을 멈춰야 하므로 isStop 변수로
						// 종료조건을 주었다.
						else isStop = true;
					}
				}
				
				if(isStop) {
					map[r][c] = 'O';
					set[c].add(r);
					break;
				}
			}
		}
		
		// 결과 맵 출력 부분
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
