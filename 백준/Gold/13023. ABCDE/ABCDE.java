import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] list = new LinkedList[n];
		for(int i=0;i<n;i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 list[a].add(b);
			 list[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			if(dfs(i,list,new boolean[n],1)==1) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
	public static int dfs(int s, LinkedList<Integer>[] list,boolean[] visited,int d) {
		visited[s] = true;
		if(d==5) {
			return 1;
		}
		
		for(int i:list[s]) {
			if(!visited[i]) {
				if(dfs(i,list,visited,d+1)==1) {
					return 1;
				}
			}
		}
		
		visited[s] = false;
		return 0;	
	}

}
