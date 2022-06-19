class 큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length();
        int idx = 0;

        for(int cnt = 0; cnt < length - k; cnt++) {
            char max = ' ';
            for(int i = idx; i <= k + cnt; i++) {
                if(number.charAt(i) > max) {
                    max = number.charAt(i);
                    idx = i + 1;

                    if(max == '9') break;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}