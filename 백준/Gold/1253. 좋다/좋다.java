import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr); // 투포인터 쓰기위해 오름 차순으로 정렬 필요
        int ans=0;

        for(int i=0;i<n;i++){
            long find = arr[i];
            int s =0;
            int e = n-1;

            //다른 수 두개
            while(s<e){ //s,e 를 여기서 조건을 준다
                if(find == arr[s]+arr[e]){
                    if(i==s){
                        s++;
                    }
                    else if(i==e){
                        e--;
                    }
                    else{
                        ans++;
                        break; // find 가 좋은 수 인거확인 했으니까 break
                    }
                }

                else if(find < arr[s]+arr[e]){
                    e--;
                }
                else{
                    s++;
                }


            }

        }

        System.out.println(ans);
    }

}
