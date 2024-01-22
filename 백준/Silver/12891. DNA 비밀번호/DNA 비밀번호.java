import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String pwd = br.readLine();
		int[] num = new int[4];
		int result =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] check = new int[4];
		init(pwd,check,0,p);
		result += count(num,check);

		
		int f=0;
		int b=f+p;
		while(b<s) {
			checkf(pwd,check,f);
			checkb(pwd,check,b);
			result += count(num,check);
			f++;
			b++;
		}
		System.out.println(result);
		
	}

	private static int count(int[] num, int[] check) {
		for(int i=0;i<4;i++) {
			if(num[i]>check[i]) {
				return 0;
			}
		}
		return 1;
		
	}
	
	private static void checkb(String pwd, int[] check, int b) {
		switch(pwd.charAt(b)) {
		case 'A':
			check[0]++;
			break;
		case 'C':
			check[1]++;
			break;
		case 'G':
			check[2]++;
			break;
		default :
			check[3]++;
			break;
		}
		
	}

	private static void checkf(String pwd, int[] check, int f) {
		switch(pwd.charAt(f)) {
		case 'A':
			check[0]--;
			break;
		case 'C':
			check[1]--;
			break;
		case 'G':
			check[2]--;
			break;
		default:
			check[3]--;
			break;
		
		}
		
	}


	private static void init(String pwd, int[] check, int s, int e) {
	
		for(int i=s;i<e;i++) {
			switch (pwd.charAt(i)) {
			case 'A':
				check[0]++;
				break;
			case 'C':
				check[1]++;
				break;
			case 'G':
				check[2]++;
				break;
			default:
				check[3]++;
				break;
			}
		}
	}
	
	
}
