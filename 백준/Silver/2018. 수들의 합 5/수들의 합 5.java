import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s=0;
		int e=1;
		int result =0;
		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] += arr[i-1]+i;
		}
		while(s!=e) {
			if(arr[e]-arr[s]<n) {
				e++;
			}
			else if(arr[e]-arr[s]>n) {
				s++;
			}
			else {
				result ++;
				s++;
			}
		}
		System.out.println(result);
		
	}

}
