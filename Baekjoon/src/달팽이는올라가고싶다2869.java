import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이는올라가고싶다2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		// V - B: 달팽이는 정상에 올라가면 미끄러지지 않으므로 미리 도착지점에서 B를 뺴줌
		// A - B: 하루가 지났을때 달팽이가 이동하는 거리
		int answer = ((V - B) / (A - B));
		// 나머지가 있으면 정상에 도착 못했으므로 1일 더해주자!
		if((V - B) % (A - B) != 0) answer++;
		System.out.println(answer);
	}

}
