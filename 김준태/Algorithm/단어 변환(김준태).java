import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        boolean firstCheck = true;
        
        // 변환할 수 없는 경우에는 0을 return;
        for(String word : words){
            if(word.equals(target)){
                firstCheck = false;
                break;
            }
        }
        if(firstCheck){
            return 0;
        }
        
        visited = new boolean[words.length];
        // 단어의 길이는 같다.
        // 한번에 한글자만 변경 가능 - 같은 글자의 갯수 COUNT
        // target일 경우 반환
        dfs(begin, target, words, 0);
        
        
        return answer;
    }
    
    static void dfs(String begin, String target, String[] words, int count){
        // 종료 조건
        if(begin.equals(target)){
            answer = count;
            return;
        }
        int strLen = begin.length();
        
        // 한글자만 다른경우 체크 해서 재귀
        for (int i = 0 ; i < words.length; i++){
            if(visited[i]){
                continue;
            }
            int k = 0;
            for(int j = 0; j < strLen; j++){
                if(words[i].charAt(j) == begin.charAt(j)){
                    k++;
                }
            }
            if (k == strLen - 1){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
}
