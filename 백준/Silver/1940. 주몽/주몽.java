

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int result = 0;
		int[] arr = new int[n];
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(arr);

		int start = 0;
		int end = n - 1;
		

		while (start < end) {
			if (arr[start] + arr[end] == m) {
				result++;
				start++;
				end--;

			} else if (arr[start] + arr[end] > m)
				end--;
			else
				start++;
		}

		System.out.println(result);

	}
}
