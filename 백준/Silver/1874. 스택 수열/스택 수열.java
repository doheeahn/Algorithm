import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean result = true;
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]  = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num =1;

        for(int i=0;i<n;i++){
            int cur = arr[i];
            if(cur>=num){
                while(cur>=num){
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            }

            else{
                int p = stack.pop();
                //
                if(cur != p){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    sb.append("-\n");
                }

            }
        }



        if(result)
            System.out.println(sb);


    }
}
