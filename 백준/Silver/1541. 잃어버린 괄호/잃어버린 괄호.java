import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int n = st.countTokens();
		int result = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			result = 0;
			StringTokenizer st1 = new StringTokenizer(st.nextToken(), "+");
			int m = st1.countTokens();
			for (int j = 0; j < m; j++) {
				result += Integer.parseInt(st1.nextToken());
			}
			list.add(result);
		}
		result = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			result -= list.get(i);
		}
		System.out.println(result);
	}
}
