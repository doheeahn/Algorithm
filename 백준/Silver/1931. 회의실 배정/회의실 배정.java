import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	public static class Meeting implements Comparable<Meeting>{
		int s,e;
		
		public Meeting(int s,int e) {
			this.s= s;
			this.e = e;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.e == o.e) {
				return this.s - o.s;
			}
			return this.e - o.e;//끝나는 시간 오름차순
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		//n개의 회의에 대하여 회의실 사용표
		//회의 시작 시간, 끝나는 시간 
		//회의의 최대 개수
		//회의 시간이 짧은거 부터 하면 많이 할 수 있어, 끝나는 시간 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans =0;
		LinkedList<Meeting> list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Meeting(s, e));
		}
		Collections.sort(list);
		int e=-1;
		for(Meeting m :list) {
			if(m.s>=e) {
				e = m.e;
				ans++;
			}
			
			
		}
		System.out.println(ans);
		
		
		
		
		
	}

}
