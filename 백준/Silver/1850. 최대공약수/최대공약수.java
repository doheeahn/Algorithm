import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		if(a<b) {
			long tmp = a;
			a= b;
			b=tmp;
		}
		long result = gcd(a,b);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<result;i++) {
			sb.append("1");
		}
		System.out.println(sb);
	}
	
	public static long gcd(long a, long b) {
		if(a%b==0) {
			return b;
		}
		return gcd(b,a%b);
	}

}
