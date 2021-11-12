class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        // computers 1 을 들어간다.
        // visited 가 0일 때 answer++ 해준다.
        for (int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    static void dfs(int depth, int[][] computers) {
        // 종료 조건
        if (visited[depth]){
            return;
        }
        visited[depth] = true;
        int[] temp = computers[depth];
        // 재귀
        for (int i = 0; i < temp.length; i++){
            if(temp[i] == 1){
                if(!visited[i] && depth != i){
                    dfs(i, computers);
                }
            }
        }
        // computers[depth][i] 는 visited가 true가 아니면 방문처리하고
        // 해당 친구의 depth로 가서 방문처리를 수행한다.
    }
}
