import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> comMap = new HashMap<>();
        
        for(int i=0;i<completion.length;i++){
            String com = completion[i];
            if(comMap.get(com)==null){
                comMap.put(com,1);
            }
            else{
                int cnt = comMap.get(com);
                comMap.put(com,cnt+1);
            }
        }
        
        for(int i=0;i<participant.length;i++){
            String par = participant[i];
            if(comMap.get(par)==null){
                answer = par;
                break;
            }
            else{
                int cnt = comMap.get(par);
                if(cnt ==1){
                    comMap.remove(par);
                }
                else{
                    comMap.put(par,cnt-1);
                }
            }
        }
        return answer;
    }
}