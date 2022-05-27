class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') sb.append(' ');
            else if('a' <= ch && ch <= 'z')
                sb.append((char)('a' + (ch - 'a' + n) % 26));
            else sb.append((char)('A' + (ch - 'A' + n) % 26));
        }

        return sb.toString();
    }
}