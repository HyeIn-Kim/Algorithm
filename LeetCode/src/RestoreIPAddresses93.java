import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {

	static String s;
	static int L;
    static int[] selected;
    static List<String> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		L = s.length();
		
		selected = new int[4];
		result = new ArrayList<String>();
		
		// IP 주소는 최소 4자리부터 최대 12자리까지이므로
		// 그 외 길이는 구하지 않음
		if(4 <= L && L <= 12) {
            permutation(0, 0);
        }
		
		System.out.println(result);
	}
	
	// 길이 L을 1~3자리로 N등분한다고 생각해서 풀었음
	// cnt: 현재까지 구한 자리수, sum: 총 자리수
	private static void permutation(int cnt, int sum) {
		// 4자리 모두 구했다면
		if(cnt == 4) {
			// 총 길이가 L일 때만 
            if(sum == L) {
            	// 구해놓은 IP주소를 String으로 합침
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < 4; i++) {
                    sb.append(selected[i]);
                    if(i != 3) sb.append(".");
                }
                
                result.add(sb.toString());
            }
            return;
        }
        
        for(int i = 1; i <= 3; i++) {
        	// 총 자리수가 L을 넘어가면 pass
            if(sum + i > L) continue;
            
            // 다음 자릿수를 구함
            String next = s.substring(sum, sum + i);
            // 만약 0이 아닌데 0으로 시작하는 수면 pass 예) 011
            if(next.length() >= 2 && next.charAt(0) == '0') continue;
            // 255 초과면 IP주소가 못되니까 pass
            if(Integer.parseInt(next) > 255) continue;
            
            // 조건에 맞는 수만 선택하고 재귀
            selected[cnt] = Integer.parseInt(next);
            permutation(cnt + 1, sum + i);
        }
	}

}
