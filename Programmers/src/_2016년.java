class _2016년 {
    public String solution(int a, int b) {
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] str = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int cnt = 0;
        for(int i = 1; i < a; i++) {
            cnt += days[i-1];
        }

        cnt += (b - 1);
        cnt += 5;
        return str[cnt % 7];
    }
}