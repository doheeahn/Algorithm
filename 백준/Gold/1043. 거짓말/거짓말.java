import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer=0;
		
		arr = new int[n+1];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=1;i<=n;i++) {
			arr[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int[] tr = new int[t];
		
		for(int i=0;i<t;i++) {
			tr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] party = new int[m];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			party[i] = first;
			for(int j=1;j<p;j++) {
				union(first,Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0;i<t;i++) {
			set.add(find(tr[i]));
		}
		
		for(int i=0;i<m;i++) {
			int a = find(party[i]);
			if(!set.contains(a)) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}

	private static void union(int first, int n) {
		int p1 = find(first);
		int p2 = find(n);
		
		if(p1 != p2) {
			arr[p2] = p1;
		}
		
	}

	private static int find(int n) {
		if(arr[n]==n) {
			return n;
		}
		
		int p = find(arr[n]);
		arr[n] = p;
		return p;

	}

}
