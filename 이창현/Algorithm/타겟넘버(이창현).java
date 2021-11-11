class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
    // ������ ���� Ž�� ���� = 0�� �ε������� ������� ��带 Ž���ؾ� �ϹǷ� ���� �ʿ� ���� 
    // dfs ���� ���� ���� =  0�� �ε������� 
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    void dfs(int[] numbers, int index, int sum, int target ){
         // �ε��� ������ Ž���ϱ� ������ �湮 ó�� �ʿ� ���� 
        // Ż�� ���� ���� 
        if(index==numbers.length){
            if(target==sum){
                answer++;
            }
            return;
        }
        //1 ���ϱ�
        dfs(numbers, index+1, sum+numbers[index],target);
        // 1����
        dfs(numbers, index+1, sum-numbers[index],target);
    }
}