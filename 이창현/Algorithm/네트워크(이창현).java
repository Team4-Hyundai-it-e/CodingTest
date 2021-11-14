class Solution {
    static boolean[] chk;
    static int [][] arr;
    static int row;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        chk = new boolean[n];
        arr = computers;
        row = n;
        for(int i=0; i<n; i++){
            if(!chk[i]){
                chk[i] = true;
                dfs(chk, arr, i);
                answer++;
            }
        }

        return answer;
    }
    
    void dfs(boolean [] chk, int [][] arr, int now){
        for(int i=0; i<row; i++){
            if(!chk[i] && arr[now][i] ==1){
                chk[i] = true;
                dfs(chk, arr, i);
            }
        }
    }
}