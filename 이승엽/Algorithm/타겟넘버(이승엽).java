import java.util.*;
class Solution {
    static int answer, len;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        dfs(target,0,0,numbers);
        return answer;
    }
    
    static void dfs(int target, int sum, int depth, int[]numbers){
        if(depth == len){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        // +
        dfs(target,sum+numbers[depth],depth+1,numbers);
        // -
        dfs(target,sum-numbers[depth],depth+1,numbers);
        
    }
}