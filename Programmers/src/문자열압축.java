public class 문자열압축 {
    public static int solution(String s) {
        int length = s.length();
        int min = Integer.MAX_VALUE;
        for(int n = 1; n <= length; n++) {
            int start = 0;
            StringBuilder sb = new StringBuilder();
            while(start < length) {
                String word = s.substring(start, Math.min(start + n, length));
                int cnt = getRepeatCnt(s, word, start + n, n, length);
                if(cnt > 1) sb.append(cnt).append(word);
                else sb.append(word);

                if(sb.length() >= min) break;
                start += n * cnt;
            }

            min = Math.min(min, sb.length());
        }

        return min;
    }

    private static int getRepeatCnt(String s, String curr, int start, int n, int length) {
        int cnt = 1;
        while(start < length) {
            String next = s.substring(start, Math.min(start + n, length));
            if(!next.equals(curr)) return cnt;
            cnt++;
            start += n;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }
}