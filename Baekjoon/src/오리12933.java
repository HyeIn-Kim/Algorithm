import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오리12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 원본 소리
        char[] sounds = br.readLine().toCharArray();
        // 오리 울음소리가 나오면 체크할 배열
        boolean[] check = new boolean[sounds.length];
        // 오리 울음소리
        char[] sound = {'q', 'u', 'a', 'c', 'k'};
        // 오리 울음소리가 난 index들
        int[] indices = new int[5];
        // 오리 개수
        int ducks = 0;
        while(true) {
            int idx = 0;        // 현재 울음소리 몇번째?
            int cnt = 0;        // 울음소리 몇번?
            
            // 전체 울음소리에서
            for(int i = 0; i < sounds.length; i++) {
                // 울음소리가 아닌 곳이 현재 울음소리랑 같으면 index를 기억,
                if(!check[i] && sounds[i] == sound[idx]) {
                    indices[idx] = i;
                    // 기억해뒀다가 quack이 모두 완성되면 그때 체크해줌
                    if(idx == 4) {
                        for(int j = 0; j < 5; j++) {
                            check[indices[j]] = true;
                        }
                        cnt++;
                    }
                    idx = (idx + 1) % 5;
                }
            }

            // 끝났는데 한번도 안울었다: 오리가 없으므로 break
            if(cnt == 0) break;
            else ducks++;

            // 끝났는데 울음소리가 울다가 말았다: 잘못된 소리이므로 break
            if(idx != 0) {
                ducks = -1;
                break;
            }
        }

        // 마지막으로 울음소리를 모두 체크해줬는지 확인.
        // 소리가 남아있으면 올바른 소리가 아님
        if(ducks != -1) {
            for(int i = 0; i < sounds.length; i++) {
                if(!check[i]) {
                    ducks = -1;
                    break;
                }
            }
        }

        // 현재까지 구한 오리 마릿수를 출력
        System.out.println(ducks);
    }
}
