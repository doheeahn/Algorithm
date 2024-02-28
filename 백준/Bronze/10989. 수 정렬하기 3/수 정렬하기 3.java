import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//ArrayList<Integer> list = new ArrayList<Integer>(); //시간초과
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			//list.add(Integer.parseInt(br.readLine()));
			arr[i] = Integer.parseInt(br.readLine());
		}
		//Collections.sort(list);
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i:arr) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}
