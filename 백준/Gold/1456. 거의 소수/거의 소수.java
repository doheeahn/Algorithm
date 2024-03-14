import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		//1~10,000,000 사이의 소수 중에서  N제곱한 값 거의 소수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long answer =0;
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		boolean[] arr = new boolean[(int) (Math.sqrt(b)+1)]; // 소수
		arr[0] = true;
		arr[1] = true;
		for(int i=2;i<=(int)Math.sqrt(b);i++) {
			int num = i;
			
			while(num+i <= (int)Math.sqrt(b)) {
				num+=i;
				arr[num] = true;
			}
		}
		
		
		//arr에서 소수 arr[i] = true인거 N 제곱 하기
		
		for(int i=2;i<=(int)Math.sqrt(b);i++) {
			if(!arr[i]) {//소수
				long num = i;
				while(num*i <= b && (num*i)%i==0) {//num제곱하면서 long범위 넘어가는거 처리 해줘야 정담
					num *=i;//num을 제곱하면서 계산 과정에서 long범위를 넘어 갈 수 있음
					if(num>=a) {
						answer ++;
					}
					
				}
			}
		}
		System.out.println(answer);
		
		
	}

}
