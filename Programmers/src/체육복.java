import java.util.*;
class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] losted = new boolean[n+1];

        for(int i = 0; i < lost.length; i++) {
            losted[lost[i]] = true;
        }

        Arrays.sort(reserve);
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < reserve.length; i++) {
            if(losted[reserve[i]]) {
                losted[reserve[i]] = false;
                set.add(reserve[i]);
                cnt++;
            }
        }

        for(int i = 0; i < reserve.length; i++) {
            int m = reserve[i];
            if(set.contains(m)) continue;
            if(m-1 > 0 && losted[m-1]) {
                losted[m-1] = false;
                cnt++;
            }
            else if(m+1 <= n && losted[m+1]) {
                losted[m+1] = false;
                cnt++;
            }
        }


        return n - (lost.length - cnt);
    }
}