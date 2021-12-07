import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 이 문제는 정말 어려웠다!!
// 1. 답을 구하는 과정
// 1-1. 문제에서 나온 대로 모든 수의 최대공약수를 구해본다. -> 시간초과
// 1-2. 수학적 아이디어로 접근해본다. (어떻게 이런걸 접근하지?)
//    	A1 = M x a1 + r1  (M: 최대공약수, a1: 몫, r1: 나머지)
//		A2 = M x a2 + r2 .... 로 N까지 반복될 때
//		r1 = r2 = ... = rn이라면 다음 식이 성립
//		A1 - A2 = M x (a1 - a2)
//		즉, A1 - A2의 최대공약수를 구하면 모든 수의 최대공약수가 되는 것!!
// 		또, 모든 수를 구하라고 했으니 최대공약수의 약수들을 같이 출력하면 답이 된다.
// 2. 약수 최적화 알고리즘
// 약수 구하는 알고리즘은 if(n % i == 0) 으로 i부터 i/2까지 돌리는 거만 알았는데
// 제곱근을 사용하면 약수를 엄청 빠르게 구할 수 있다! 무려 882ms -> 88ms로 줄었다;;;;
public class 검문2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		// 음수 나오지 말라고 입력값을 먼저 정렬해줬음!
		Arrays.sort(numbers);
		
		// Ai - A(i-1)들의 최대공약수를 구해주고
		int gcd = numbers[1] - numbers[0];
		for(int i = 2; i < N; i++) {
			gcd = GCD(gcd, numbers[i] - numbers[i-1]);
		}
		
		// 약수를 구해준다.
		// 만약 100의 약수를 구한다 치면, Sqrt(100)은 10.
		// 2는 100의 약수이고, 100/2 = 50도 마찬가지로 100의 약수인 점을 이용해서
		// 제곱근까지만 살펴보면 구할 수 있음.
		List<Integer> arr = new ArrayList<>();
		for(int i = 2; i <= Math.sqrt(gcd); i++) {
			// 10 * 10(제곱근)은 중복되니까 한번만 넣어주는 게 포인트
			if(i * i == gcd) arr.add(i);
			else if(gcd % i == 0){
				arr.add(i);
				arr.add(gcd / i);
			}
		}
		
		// 문제 조건에 맞게 오름차순 정렬을 해주고 출력한다.
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(Integer i : arr) {
			sb.append(i + " ");			
		}
		sb.append(gcd);
		
		System.out.println(sb.toString());
	}
	
	private static int GCD(int a, int b) {
		int temp = 0;
		while(b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}

}
