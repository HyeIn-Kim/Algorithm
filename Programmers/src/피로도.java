class 피로도 {
    int max = 0;
    boolean[] selected;
    public int solution(int k, int[][] dungeons) {
        selected = new boolean[dungeons.length];
        permutation(0, k, 0, dungeons);
        return max;
    }

    private void permutation(int idx, int k, int cnt, int[][] dungeons) {
        if(idx == dungeons.length) {
            max = Math.max(max, cnt);
            return;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(selected[i]) continue;

            selected[i] = true;
            if(k >= dungeons[i][0]) permutation(idx + 1, k - dungeons[i][1], cnt + 1, dungeons);
            else permutation(idx + 1, k, cnt, dungeons);
            selected[i] = false;
        }
    }
}