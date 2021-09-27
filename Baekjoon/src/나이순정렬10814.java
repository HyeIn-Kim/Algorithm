import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순정렬10814 {

	static class Member {
		int no;			// 입력 순서
		int age;		// 나이
		String name;	// 이름
		
		public Member(int no, int age, String name) {
			super();
			this.no = no;
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Member> members = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		// Comparator Interface를 사용하여 비교!
		// 나이 순대로 비교한 뒤, 나이가 같다면 입력 순서대로 정렬하였다!
		Collections.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age < o2.age) return -1;
				else if(o1.age == o2.age) {
					return o1.no - o2.no;
				}
				else return 1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Member m : members) {
			sb.append(m.age + " " + m.name + "\n");
		}
		System.out.println(sb);
	}

}
