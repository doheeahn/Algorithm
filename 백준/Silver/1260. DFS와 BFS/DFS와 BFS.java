import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static int n;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 정점
		int m = Integer.parseInt(st.nextToken());// 간선
		int v = Integer.parseInt(st.nextToken());// 시작
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 1; i <= n; i++) {
			list[i].sort(Comparator.naturalOrder());
		}

		dfs(v);
		sb.append("\n");
		bfs(v);
		System.out.println(sb);
	}

	private static void bfs(int i) {
		visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i]=true;

		while (!queue.isEmpty()) {
			int current=queue.poll();
			sb.append(current +" ");
			
			for (int d = 0; d < list[current].size(); d++) {
				int n = list[current].get(d);
				if (!visited[n]) {
					queue.add(n);
					visited[n]=true;
				}	
			}
		}
	}

	private static void dfs(int i) {
		sb.append(i + " ");
		visited[i] = true;

		for (int d = 0; d < list[i].size(); d++) {
			int n = list[i].get(d);
			if (!visited[n]) {
				dfs(n);
			}
		}

	}
}
