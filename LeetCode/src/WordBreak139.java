import java.util.*;

// 어려웠던 DP 문제.
// 주어진 string s가 wordDict만으로 이루어질 수 있는지 찾는 문제.
// 처음에는 DFS로 substring을 줄여가면서 풀었었는데, 당연히 시간 초과가 났다.
class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // 문자열 길이 n만큼의 DP 배열
        // DP[i]: 길이 i만큼의 문자열이 wordDict로만 만들 수 있으면 true
        // n - 1이 true라면 String s가 wordDict에 있는 단어들로만 구성됨
        boolean[] DP = new boolean[n];

        // i: 문자열 길이 0 ~ n-1 까지
        for(int i = 0; i < n; i++) {
            // j: 지금까지 본 0 ~ i 사이에서 substring의 시작 위치를 옮겨줌
            // i = 7
            // j = 0 sub = leetcode
            // j = 1 sub = eetcode
            // j = 2 sub = etcode
            // j = 3 sub = tcode
            // j = 4 sub = code && DP[3] and then break
            for(int j = 0; j <= i; j++) {
                // j == 0: j == 0일때 DP[j - 1]에 접근할 수 없기 때문임
                // DP[j - 1]: 내가 만약 위 예시처럼 i = 7, j = 4인데 code가 wordDict에 있는 문자열임을 알게 되었다
                //            DP[7]까지의 모든 문자가 wordDict에 포함되려면 code의 이전 문자열, leet(DP[3], 3 = j - 1) 도 wordDict에 포함되어 있어야 한다
                //            따라서 DP[j - 1]
                if(j == 0 || DP[j - 1]) {
                    String sub = s.substring(j, i + 1);
                    if(wordDict.contains(sub)) {
                        DP[i] = true;
                        break;  // 찾았으면 뒤에 더 볼 필요 없이 종료 가능
                    }
                }
            }
        }

        return DP[n - 1];
    }
}