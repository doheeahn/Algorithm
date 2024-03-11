import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int start = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(start < num) {
				start = num;
			}
			arr[i]= arr[i-1]+ num;
		}
		int end = arr[n];

		while(start <= end) {
			int mid = (start+end)/2;
			int cnt =1;
			int s=0;
			for(int i=1;i<=n;i++) {
				if(arr[i] - arr[s] > mid) {
					s=i-1;
					cnt++;
				}
			}
			if(cnt >m) {
				start = mid +1;
			}
			else {
				end = mid -1;
			}
		}
		System.out.println(start);

		
		
	}
}
