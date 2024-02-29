import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	public static class Index {
		int i,j;
		
		public Index(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		Queue<Index> queue = new LinkedList<>();
		queue.offer(new Index(0,0));
		int ans=1;
		
		while(!queue.isEmpty()) {
			int num = queue.size();
			ans++;
			
			for(int i=0;i<num;i++) {
				Index cur = queue.poll();
				for(int d=0;d<4;d++) {
					int x = cur.i+di[d];
					int y = cur.j+dj[d];

					if(x>=0 && x<n && y>=0 && y<m && arr[x][y]==1) {
						if(x==n-1 && y==m-1) {
							System.out.println(ans);
							return;
						}
						arr[x][y]=2;
						queue.offer(new Index(x, y));
					}
				}
			}
			
		}
		
		
	}

}
