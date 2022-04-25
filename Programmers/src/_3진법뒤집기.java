class _3진법뒤집기 {
    public int solution(int n) {
        char[] ternary = getTernary(n);

        int sum = 0;
        for(int i = ternary.length - 1; i >= 0; i--) {
            int a = ternary[i] - '0';
            int b = (int)Math.pow(3, (ternary.length - 1 - i));
            sum += a * b;
        }

        return sum;
    }

    char[] getTernary(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        return sb.toString().toCharArray();
    }
}