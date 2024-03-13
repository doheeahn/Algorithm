import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans =0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<n;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		while(pq.size()>1) {
			int n1 = pq.poll();
			int n2 = pq.poll();
			
			pq.offer(n1+n2);
			ans += (n1+n2);
		}
		
		System.out.println(ans);
		
	}

}
