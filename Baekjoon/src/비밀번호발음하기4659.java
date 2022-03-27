import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호발음하기4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input.equals("end")) break;

            char[] arr = input.toCharArray();
            boolean hasVowel = false;
            boolean isAcceptable = true;
            boolean isVowel = false;
            int cnt = 1;
            if(arr[0] == 'a' || arr[0] == 'e' || arr[0] == 'i' || arr[0] == 'o' || arr[0] == 'u') {
                hasVowel = true;
                isVowel = true;
            }

            for(int i = 1; i < input.length(); i++) {
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    if(!hasVowel) hasVowel = true;
                    if(!isVowel) {
                        isVowel = true;
                        cnt = 1;
                    }
                    else cnt++;
                }
                else {
                    if(isVowel) {
                        isVowel = false;
                        cnt = 1;
                    }
                    else cnt++;
                }

                if(cnt == 3) {
                    isAcceptable = false;
                    break;
                }

                if(arr[i-1] == arr[i]) {
                    if(!(arr[i] == 'e' || arr[i] == 'o')) {
                        isAcceptable = false;
                        break;
                    }
                }
            }

            if(hasVowel && isAcceptable) sb.append("<" + input + "> is acceptable.\n");
            else sb.append("<" + input + "> is not acceptable.\n");
        }

        System.out.println(sb);
    }
}
