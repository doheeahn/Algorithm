import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main{
	public static class Num{
		int n,idx;
		
		public Num(int n, int idx) {
			this.n = n;
			this.idx =idx;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Num[] arr = new Num[n];
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = new Num(num,i);
		}
		Arrays.sort(arr,(o1,o2)->o1.n - o2.n);
		int ans =0;
		for(int i=0;i<n;i++) {
			if(arr[i].idx - i >ans) {
				ans = arr[i].idx - i;
			}
		}
		System.out.println(ans+1);
		
	}

}
