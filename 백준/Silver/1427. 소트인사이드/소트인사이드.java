import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = s.charAt(i)-'0';
        }

        for(int i=0;i<n;i++){
            int max =i;

            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[max])
                    max = j;
            }
            if(i != max){
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max]= tmp;
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }

    }
}
