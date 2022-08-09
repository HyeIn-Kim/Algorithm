class 최소직사각형 {
    public int solution(int[][] sizes) {
        int n1 = 0;
        int n2 = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] > sizes[i][1]) {
                n1 = Math.max(n1, sizes[i][0]);
                n2 = Math.max(n2, sizes[i][1]);
            }
            else {
                n1 = Math.max(n1, sizes[i][1]);
                n2 = Math.max(n2, sizes[i][0]);
            }
        }

        int answer = n1 * n2;
        return answer;
    }
}