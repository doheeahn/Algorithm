import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double max = 0;
		double[] arr = new double[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			max = max > arr[i]? max: arr[i];
		}
		double avg=0;
		for(int i=0;i<n;i++) {
			avg += arr[i]/max*100;

		}
		avg/=n;
		
		System.out.println(avg);
		
	}

}
