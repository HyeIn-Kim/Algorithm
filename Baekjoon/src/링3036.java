import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분수 약분을 어떻게 하면 좋을까?
// 아하! 최대공약수를 구해서 분자, 분모를 최대공약수로 나눠주면 되는구나!
public class 링3036 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = 0;
		for(int i = 0; i < N; i++) {
			int ring = Integer.parseInt(st.nextToken());
			if(i == 0) first = ring;
			else {
				int GCD = (first > ring) ? EuclideanAlgorithm(first, ring) : EuclideanAlgorithm(ring, first);
				sb.append((first / GCD) + "/" + (ring / GCD) + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static int EuclideanAlgorithm(int a, int b) {
		int temp = 0;
		while(b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}

}
