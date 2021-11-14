import java.util.*;
class Solution {
    static ArrayList<String> li;
    static int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        boolean[] used = new boolean[len];
        li = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            if(tickets[i][0].equals("ICN")){
                used[i] = true;
                dfs(tickets,used,1,tickets[i][0]+" "+tickets[i][1],tickets[i][1]);
                used[i] = false;
            }     
        }
        
        li.sort(null);
        
        return li.get(0).split(" ");
    }
    
    static void dfs(String[][] tickets, boolean[] used, int depth, String result, String start){
        if(depth == len){
            li.add(result);
            return ;
        }
        
        for(int i = 0; i < len; i++){
            if(tickets[i][0].equals(start) && !used[i]){
                used[i] = true;
                dfs(tickets,used,depth+1,result+" "+tickets[i][1],tickets[i][1]);
                used[i] = false;
            }
        }
        
    }
}