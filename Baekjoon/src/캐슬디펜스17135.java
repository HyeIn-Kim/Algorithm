import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 처음에는 1. 적을 한칸씩 내림 / 2. 에너미의 좌표를 저장하여 갱신하면서 진행 이었는데
// 적을 내리는 게 아니라 궁수를 올리면 적 좌표를 변경할 일 없이 진행 가능하고,
// ArrayList로 적의 위치를 관리하는 거보다 그냥 배열을 돌면서 적을 찾는 게 더 빨랐다!!
public class 캐슬디펜스17135 {
	
	// 적군의 위치 (r, c)를 저장할 클래스
	static class Enemy {
		int r;
		int c;
		
		public Enemy(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, D;
	static int[][] map;					// 게임 맵
	static int[][] copyMap;				// 맵 초기화용 복사본
	static int[] selected;				// 궁수 조합 선택 배열
	static int result;					// 결과값
	static int archers;					// 현재 궁수 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
			}
		}
		
		result = Integer.MIN_VALUE;
		selected = new int[3];
		castleDefence(0, 0);
		System.out.println(result);
	}

	// 궁수는 가로 M개에서 3명을 배치해야 하므로 MC3의 조합이다.
	private static void castleDefence(int n, int start) {
		if(n == 3) {
			// 맵과 궁수 위치를 초기화한다.
			archers = N;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = copyMap[i][j];
				}
			}
			
			int cnt = 0;
			// 1. N턴만큼 반복해서
			for(int i = 0; i < N ; i++) {
				// 2. 가장 가까운 적을 찾아서 궁수가 쏜다
				ArrayList<Enemy> attacked = findNearestEnemy();
				
				// 궁수가 차례대로 적을 공격한다.
				for(int j = 0; j < attacked.size(); j++) {
					int r = attacked.get(j).r;
					int c = attacked.get(j).c;
					
					// 궁수들이 같은 적을 여러 번 쏠 수 있으므로,
					// 각각의 적을 처음 1번 쏠 때만 cnt를 증가시킨다.
					if(map[r][c] == 1) {
						map[r][c] = 0;
						cnt++;
					}
				}
				
				// 궁수가 맵 한칸 위로 올라간다.
				archers--;
			}
			
			// 궁수가 쓰러트린 적의 최대값 갱신
			result = Math.max(result, cnt);
			return;
		}
		
		// 궁수 조합 뽑는 코드
		for(int i = start; i < M; i++) {
			selected[n] = i;
			castleDefence(n + 1, i + 1);
		}
	}

	private static ArrayList<Enemy> findNearestEnemy() {
		ArrayList<Enemy> result = new ArrayList<>();
		// 각 궁수마다
		for(int a = 0; a < 3; a++) {
			int minD = Integer.MAX_VALUE;		// 최단거리
			int minR = -1;						// 최단거리 적의 R위치
			int minC = -1;						// 최단거리 적의 C위치
			
			// 맵을 한번씩 돌면서 적을 찾는다.
			// N까지 도는게 아니라 궁수 위치까지만 확인하면 된다.
			for(int i = 0; i < archers; i++) {
				for(int j = 0; j < M; j++) {
					// 적을 발견하면
					if(map[i][j] == 1) {
						// 거리를 계산
						int distance = Math.abs(archers - i) + Math.abs(selected[a] - j);
						if(distance > D) continue;
						
						// 거리가 D 이하일 때만 최단거리, R, C를 갱신
						if(distance < minD) {
							minD = distance;
							minR = i;
							minC = j;
						}
						else if(distance == minD && j < minC) {
							minR = i;
							minC = j;
						}
					}
				}
			}
			
			// 적을 찾지 못했으면 pass
			if(minR == -1 && minC == -1) continue;
			// 찾은 적을 리스트에 넣는다.
			result.add(new Enemy(minR, minC));				
		}
		
		// 이번에 쏠 적들의 R, C 좌표가 담긴 리스트를 반환
		return result;
	}
}
