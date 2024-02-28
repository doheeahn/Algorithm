import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i:list) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}
