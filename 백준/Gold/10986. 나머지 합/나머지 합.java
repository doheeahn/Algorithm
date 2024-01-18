import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long ans =0;
		
		int[] arr = new int[n+1];
		int[] mod = new int[m];
		st = new StringTokenizer(br.readLine());
		//연속 구간 합 별 나머지 구하기
		for(int i=1;i<=n;i++) {
			arr[i] = (arr[i-1]+Integer.parseInt(st.nextToken()))%m;
			mod[arr[i]]++;

		}
		ans+=mod[0];//1부터 i 까지의 합의 나머지가 0으로 m으로 나누어 떨어지는 부분의 개수
		for(int i=0;i<m;i++) {
			//연속합을 빼면 구간 합을 구할 수 있음
			//뺐을때 나머지가 0이면 해당 구간이 m으로 나누어 떨어진다는 의미
			//조합으로 2개 뽑기
			ans += ((long)mod[i]*(long)(mod[i]-1))/2;
		}
		
		System.out.println(ans);
		
	}
}
