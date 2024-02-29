import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;  // arraylist 2차원 배열 선언
	static boolean[] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int result =0;
		
		arr = new ArrayList[n + 1];
		visit = new boolean[n+1];
		
		
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			arr[n1].add(n2);
			arr[n2].add(n1);

		}
		for (int i = 1; i <= n; i++) {
			if(!visit[i]) {
				v(i);
				result ++;
			}
		}
		System.out.println(result);
	}

	public static void v(int a) {
		visit[a]=true;
		for(int i : arr[a]) {
			if(!visit[i]) v(i);
		}
	}
}
