import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int now = q.poll();
                    for(int j = 0; j < n; j++){
                        if(j == now){
                            continue;
                        }
                        if(computers[now][j] == 1 && !visited[j]){
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}