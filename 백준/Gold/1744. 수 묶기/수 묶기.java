import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		//0,1말고는 무조건 묶여야지 이득, 음수는 음수 끼리, 양수는 양수 끼리 곱, 0은 음수 하나 남을때 없애기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans =0;
		boolean zero = false;
		PriorityQueue<Integer> positive = new PriorityQueue<Integer>((o1,o2)->o2-o1);
		PriorityQueue<Integer> negative = new PriorityQueue<Integer>();
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num ==1) {
				ans += num;
			}
			else if(num ==0) {
				zero = true;
			}
			else if(num >0) {
				positive.offer(num);
			}
			else {
				negative.offer(num);
			}
		}
		
		while(positive.size() >1) {
			ans += positive.poll()*positive.poll();
		}
		if(positive.size()==1) {
			ans += positive.poll();
		}
		
		while(negative.size() >1) {
			ans += negative.poll()*negative.poll();
		}
		if(negative.size()==1) {
			if(!zero)
				ans += negative.poll();
		}
		
		System.out.println(ans);
		
	}
	

}
