import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public interface Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//N종류의 동전
		//동전의 합을 k로 만들기
		//필요한 동전의 개수를 최소-> 큰거 부터 채우기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		
		for(int i=n-1;i>=0;i--) {
			if(k ==0) {
				break;
			}
			if(arr[i]>k) {
				continue;
			}
			
			ans += (k/arr[i]);
			k = k%arr[i];
		}
		
		System.out.println(ans);
		
		
	}

}
