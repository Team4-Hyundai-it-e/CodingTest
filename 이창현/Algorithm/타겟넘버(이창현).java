class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
    // 루프를 통해 탐색 시작 = 0번 인덱스부터 순서대로 노드를 탐색해야 하므로 루프 필요 없음 
    // dfs 진입 조건 설정 =  0번 인덱스부터 
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    void dfs(int[] numbers, int index, int sum, int target ){
         // 인덱스 순으로 탐색하기 때문에 방문 처리 필요 없음 
        // 탈출 조건 정의 
        if(index==numbers.length){
            if(target==sum){
                answer++;
            }
            return;
        }
        //1 더하기
        dfs(numbers, index+1, sum+numbers[index],target);
        // 1빼기
        dfs(numbers, index+1, sum-numbers[index],target);
    }
}