import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		Queue<String> queue = new LinkedList<>();
		queue.offer("2");
		queue.offer("3");
		queue.offer("5");
		queue.offer("7");
		
		while(!queue.isEmpty() && n >1) {
			String cur = queue.poll();
			for(int i=0;i<10;i++) {
				int com = Integer.parseInt(cur + Integer.toString(i));
				boolean check = true;
				for(int j=2;j<=Math.sqrt(com);j++) {
					if(com %j ==0) {
						check = false;//소수 아님
						break;
					}
				}
				
				if(check) { //소수
					String s = Integer.toString(com);
					if(s.length() == n) {
						list.add(com);
					}
					else {
						queue.offer(Integer.toString(com));
					}

				}
			}
		}
		while(!queue.isEmpty()) {
			list.add(Integer.parseInt(queue.poll()));
		}
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}

}
