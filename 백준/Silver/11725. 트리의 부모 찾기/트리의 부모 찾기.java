import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[n+1];
		result = new int[n+1];
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		dfs(1,list,new boolean[n+1]);
		for(int i=2;i<=n;i++) {
			System.out.println(result[i]);
		}
		
	}

	private static void dfs(int i, ArrayList<Integer>[] list, boolean[] visited) {
		
		for(int num : list[i]) {
			if(visited[num]) {
				continue;
			}
			visited[num] = true;
			result[num] = i;
			dfs(num,list,visited);
		}
		
		
	}

}
