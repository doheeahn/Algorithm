import java.util.*;
class Solution {
    static int[] l = {0,8,16};
    static int[] g = {0,4};
    static int[] c = {0,2};
    static int[] f = {0,1};
    static ArrayList<Integer>[] arr = new ArrayList[33];
    static int[] answer;
    static Map<String,Integer> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        map.put("cpp",0);
        map.put("java",8);
        map.put("python",16);
        map.put("backend",0);
        map.put("frontend",4);
        map.put("junior",0);
        map.put("senior",2);
        map.put("chicken",0);
        map.put("pizza",1);
        map.put("-",-1);
        

        for(int i=0;i<33;i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<info.length;i++){
            StringTokenizer st = new StringTokenizer(info[i]);
            int idx = checkInfo(st.nextToken(), st.nextToken(),st.nextToken(),st.nextToken());
            arr[idx].add(Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0;i<33;i++){
            Collections.sort(arr[i]);
        }
        
        
        for(int i=0;i<query.length;i++){
            String[] q = query[i].split(" and | ");
            int sum =0;
            for(int j=0;j<4;j++){
                if(map.get(q[j])!=-1){
                    sum += map.get(q[j]);
                }
            }
            ans(q,sum,i);
        }
        
        return answer;
    }
    
    public void ans(String[] q,int sum,int idx){
        for(int i=0;i<3;i++){
            sum += l[i];
            for(int j=0;j<2;j++){
                sum += g[j];
                for(int k=0;k<2;k++){
                    sum += c[k];
                    for(int t=0;t<2;t++){
                        sum += f[t];
                        int num = Integer.parseInt(q[4]);
                        //이분 탐색
                        int s =0;
                        int e = arr[sum].size();
                        while(s<e){
                            int mid = (s+e)/2;
                            if(arr[sum].get(mid) < num){
                                s = mid+1;
                            }
                            else{
                                e = mid;
                            }           
                        }
                        answer[idx] += arr[sum].size()-s;
                        sum -= f[t];
                        if(map.get(q[3])!=-1){
                            break;
                        }
                    }
                    sum -=c[k];
                    if(map.get(q[2])!=-1){
                        break;
                    }
                }
                sum -= g[j];
                if(map.get(q[1])!=-1){
                    break;
                }
            }
            sum -= l[i];
            if(map.get(q[0])!=-1){
                break;
            }
        }
    }
    
    
    public int checkInfo(String l,String g,String c, String f){
        int sum =0;
        sum =sum+ map.get(l) + map.get(g)+map.get(c)+map.get(f);
        return sum;
        
    }
}