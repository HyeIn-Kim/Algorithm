class 도둑질 {
    public int solution(int[] money) {
        int length = money.length;
        // 점화식은 맞았는데 원형 배열에서 삑났음.
        // 0~마지막요소-1 배열과 1~마지막요소 배열로 DP를 2개로 만들어서 최댓값을 비교한다!!
        int[] DP1 = new int[length];
        int[] DP2 = new int[length];
        DP1[1] = money[0];
        DP2[1] = money[1];
        for(int i = 2; i < length; i++) {
            DP1[i] = Math.max(DP1[i-1], DP1[i-2] + money[i-1]);
            DP2[i] = Math.max(DP2[i-1], DP2[i-2] + money[i]);
        }

        return Math.max(DP1[length-1], DP2[length-1]);
    }
}