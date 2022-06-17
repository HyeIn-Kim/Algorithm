class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 3, h = 3;
        while(true) {
            int b = (2 * w) + (2 * h) - 4;
            int y = w * h - b;
            if(b == brown && y == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }

            if(b < brown) w++;
            else {
                h++;
                w = h;
            }
        }

        return answer;
    }
}