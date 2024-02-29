import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int n,m;
    static int[] di= {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static Queue<Node> queue = new LinkedList<>();
    static char[][] map;

    public static class Node{
        int i,j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        queue.offer(new Node(0,0));
        map[0][0]='2';
        int ans = bfs(1);
        System.out.println(ans);



    }

    private static int bfs(int cnt) {

        while(!queue.isEmpty()){
            int num = queue.size();

            for(int t=0;t<num;t++){
                Node cur = queue.poll();
                int i = cur.i;
                int j = cur.j;
                if(i+1==n && j+1==m){
                    queue.clear();
                    break;
                }
                for(int d=0;d<4;d++){

                    if(i+di[d]>=0 && i+di[d]<n && j+dj[d]>=0 && j+dj[d]<m && map[i+di[d]][j+dj[d]]=='1'){
                        map[i+di[d]][j+dj[d]]='2';
                        queue.offer(new Node(i+di[d],j+dj[d]));
                    }
                }
            }
            cnt++;
        }

        return cnt-1;
    }

}
