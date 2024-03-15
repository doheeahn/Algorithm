import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 =  Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(n1 <n2) {
				int tmp = n1;
				n1 = n2;
				n2 = tmp;
			}
			int result = gcd(n1,n2);
			
			System.out.println(n1*n2/result);
			
			
		}
	}
	
	public static int gcd(int n1, int n2) {
		if(n1 %n2 ==0) {
			return n2;
		}
		
		return gcd(n2, n1%n2);
		
	}

}
