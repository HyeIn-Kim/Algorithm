import java.util.*;

// 노래 정보를 저장하는 클래스 Song
class Song {
    int play;				// 재생 횟수
    int index;				// 곡 번호
    
    public Song(int play, int index) {
        this.play = play;
        this.index = index;
    }
}

// 장르 정보를 저장하는 클래스 Genre
class Genre {
    int plays;					// 장르의 총 플레이 횟수
    PriorityQueue<Song> pq;		// 장르 별 노래 정보를 저장하는 PQ
    
    public Genre() {
        this.plays = 0;			// 초기값 0으로
        // 문제 조건에 맞게 PQ를 설정
        this.pq = new PriorityQueue<>((a, b) -> {
            if(a.play == b.play) return a.index - b.index;
            else return b.play - a.play;
        });
    }
}

class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {      
        Map<String, Genre> map = new HashMap<>();
        int size = genres.length;
        for(int i = 0; i < size; i++) {
        	// 장르가 map에 있는지 확인하고
            Genre g = map.getOrDefault(genres[i], null);
            // 없으면 새로 만들어줌
            if(g == null) g = new Genre();
            // 노래 정보와 재생횟수를 추가한 뒤
            g.pq.add(new Song(plays[i], i));
            g.plays += plays[i];
            
            // map에 다시 넣음
            map.put(genres[i], g);
        }
        
        // 재생횟수를 다 구했으면 map을 재생횟수 순으로 정렬해준다.
        List<Map.Entry<String, Genre>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue().plays - a.getValue().plays);
        
        // 정렬한 장르를 처음부터 쭉 돌면서
        // 재생이 가장 많이 된 노래 2개씩 뽑아줌
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Genre> entry : entries) {
            Genre g = entry.getValue();
            int cnt = 0;
            // 1개면 1개만 뽑음
            while(!g.pq.isEmpty() && cnt < 2) {
                list.add(g.pq.poll().index);
                cnt++;
            }
        }

        // 반환형이 int[]이므로 ArrayList를 int[]로 옮겨줌
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}