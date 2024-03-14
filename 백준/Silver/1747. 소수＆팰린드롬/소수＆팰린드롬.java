import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[10000001];
		arr[0] = true;
		arr[1] = true;
		for(int i=2;i<10000001;i++) {
			int num = i+i;
			while(num <= 10000000) {
				arr[num] = true;
				num +=i;
			}
		}
		
		for(int i=n;i<=10000000;i++) {
			if(!arr[i] && isAvailable(i)) {//소수
				System.out.println(i);
				break;
			}
		}
		
		
	}
	
	public static boolean isAvailable(int num) {
		String s = Integer.toString(num);
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == s.charAt(s.length()-i-1)) {
				continue;
			}
			return false;
		}
		return true;
		
	}

}
