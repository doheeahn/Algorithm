
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)-> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1==abs2)
				return o1-o2;//오름차순
			else
				return abs1-abs2;
				
		});
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}
				else {
					sb.append(pq.poll()+"\n");
				}
			}
			else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}

}
