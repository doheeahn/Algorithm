
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);//처음에는 비어 있으니까 일단 0번 인덱스 push
		
		for(int i=1;i<n;i++) {//n만큼 확인하기
			while(!stack.isEmpty() && arr[stack.peek()] <arr[i]) {//스택 안에는 아직 오른쪽에 자기보다 큰 애 못만남
				result[stack.pop()] = arr[i]; 
			}
			stack.push(i);
			
		}
		//반복문 다 돌고 나왔는데 스택이 비어있지 않다면 
		while(!stack.isEmpty()) {
			result[stack.pop()]= -1;
		}
		
		for(int i=0;i<n;i++) {
			sb.append(result[i]+" ");
		}
		System.out.println(sb);
	}
}
