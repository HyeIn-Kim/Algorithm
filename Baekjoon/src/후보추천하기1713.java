import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 후보추천하기1713 {
    static class Photo {
        int n;
        int time;

        public Photo(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] candidates = new int[101];
        List<Photo> photos = new ArrayList<>();
        for(int t = 0; t < T; t++) {
            int candidate = Integer.parseInt(st.nextToken());
            candidates[candidate]++;

            // 1. 이미 걸려 있는 사진인지 확인
            boolean isPhoto = false;
            for(Photo photo : photos) {
                if(photo.n == candidate) {
                    isPhoto = true;
                    break;
                }
            }

            if(isPhoto) continue;

            // 2. 추천 리스트가 비어있으면 그대로 사진 추가
            if(photos.size() < N) {
                photos.add(new Photo(candidate, t));
                continue;
            }

            // 3. 추천 리스트가 차있으면 추천수가 가장 적은 사진을 고름
            int min = Integer.MAX_VALUE;
            ArrayList<Photo> minPhotos = new ArrayList<>();
            for(Photo photo : photos) {
                if(candidates[photo.n] < min) {
                    min = candidates[photo.n];
                    minPhotos.clear();
                    minPhotos.add(photo);
                }
                else if(candidates[photo.n] == min) {
                    minPhotos.add(photo);
                }
            }

            // 4. 가장 오래 된 사진을 삭제하고 사진 추가
            Photo old = minPhotos.get(0);
            for(Photo photo : minPhotos) {
                if(photo.time < old.time) {
                    old = photo;
                }
            }

            candidates[old.n] = 0;
            photos.remove(old);
            photos.add(new Photo(candidate, t));
        }

        // 5. 오름차순 정렬 후 출력
        Collections.sort(photos, (o1, o2) -> o1.n - o2.n);
        StringBuilder sb = new StringBuilder();
        for(Photo photo : photos) {
            sb.append(photo.n).append(" ");
        }

        System.out.println(sb);
    }
}
