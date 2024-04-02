
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] city = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		
		for(int i=0;i<=n;i++) {
			city[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			city[c1].add(c2);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		visited[s]=true;
		int cnt =0;
		while(!queue.isEmpty() && cnt !=k) {
			int num = queue.size();
			for(int i=0;i<num;i++) {
				int next = queue.poll();
				for(int j: city[next]) {
					if(visited[j]) {
						continue;
					}
					queue.offer(j);
					visited[j] = true; 
				}
			}
			cnt++;
		}
		
		int size = queue.size();
		if(size==0) {
			System.out.println(-1);
		}
		else {
			LinkedList<Integer> list = new LinkedList<Integer>(queue);
			Collections.sort(list);
			for(int i :list) {
				System.out.println(i);
			}
		}
		
	}

}
