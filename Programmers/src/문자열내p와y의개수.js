function solution(s){
        let cntP = 0;
        let cntY = 0;
        for(let i = 0; i < s.length; i++) {
                switch(s[i].toLowerCase()) {
                case 'p': cntP++; break;
                case 'y': cntY++; break;
                }
        }

        return cntP == cntY ? true : false;
}