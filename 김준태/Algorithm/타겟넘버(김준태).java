class Solution {
    static boolean visited[];
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        visited = new boolean[numbers.length];
        
        // dfs 및 카운트 증가
        dfs(0, numbers, 0, target);
        
        return answer;
    }
    
    static void dfs(int depth, int[] numbers, int sum, int target){
        // 종료조건
        if (depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        if (visited[depth]){
            return;
        }
        // 재귀
        visited[depth] = true;
        dfs(depth + 1, numbers, sum + numbers[depth], target);
        dfs(depth + 1, numbers, sum - numbers[depth], target);
        visited[depth] = false;
    }
}
