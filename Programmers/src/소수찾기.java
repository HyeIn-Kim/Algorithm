import java.util.*;

class 소수찾기 {
    public int cntPrimes(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(isPrime[i]) continue;
            for(int j = i + i; j <= n; j += i) {
                isPrime[j] = true;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(!isPrime[i]) list.add(i);
        }

        return list.size();
    }

    public int solution(int n) {
        return cntPrimes(n);
    }
}