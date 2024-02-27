class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right-left)+1;
        int[] answer = new int[size];
        int c1 = (int)((left)/n);
        int c2 = (int)((left)%n);
        int idx =0;
        
        while(idx<size){
            if(c2 <= c1){
                for(;c2<=c1;c2++){
                    if(idx >=size){// 마지막 idx 체크해야함
                        break;
                    }
                    answer[idx] = c1+1;
                    idx++;
                }
            }
            else{
                answer[idx] = c2+1;
                idx++;
                c2++;
                if(c2 == n){
                    c1++;
                    c2=0;
                }
            }
        }
        
        
        return answer;
    }
}