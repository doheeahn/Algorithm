import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] max;
	public static class Tree{
		int num,len;
		
		public Tree(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		LinkedList<Tree>[] list = new LinkedList[v+1];

		for(int i=1;i<=v;i++) {
			list[i] = new LinkedList<Tree>();
		}
		
		for(int i=0;i<v;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			int len =0;
			
			while(num !=-1) {
				len= Integer.parseInt(st.nextToken());
				list[s].add(new Tree(num, len));
				num = Integer.parseInt(st.nextToken());
			}	
		}
		
			visited = new boolean[v+1];
			max = new int[v+1];
			visited[1] = true;
			dfs(1,list);
			
			int m =0;
			for(int i=1;i<=v;i++) {
				if(max[m] < max[i]) {
					m = i;
				}
			}
			
			visited = new boolean[v+1];
			max = new int[v+1];
			visited[m] = true;
			dfs(m,list);
			
			m =0;
			for(int i=1;i<=v;i++) {
				if(m < max[i]) {
					m = max[i];
				}
			}
			
			System.out.println(m);
			
			


	}
	
	public static void dfs(int s, LinkedList<Tree>[] list) {
		
		for(Tree node :list[s]) {
			if(!visited[node.num]) {
				visited[node.num] = true;
				max[node.num] = max[s]+node.len;
				dfs(node.num,list);
			}
		}
		
		
	}
}
