import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int city = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		c = new int[city+1];
		for(int i=1;i<=city;i++) {
			c[i] = i;
		}
		
		for(int i=1;i<=city;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=city;j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					union(i,j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = find(Integer.parseInt(st.nextToken()));
		
		for(int i=0;i<t-1;i++) {
			if(p !=find(Integer.parseInt(st.nextToken()))){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void union(int i, int j) {
		int ip = find(i);
		int jp = find(j);
		
		if(ip !=jp) {
			c[jp] = ip;
		}
		
	}

	private static int find(int i) {
		if(i == c[i]) {
			return i;
		}
		else {
			c[i] = find(c[i]);
			return c[i];
		}
		
	}

}
