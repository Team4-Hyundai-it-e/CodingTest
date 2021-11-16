package boj;

import java.io.*;
import java.util.*;

public class Boj_2644 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 사람 수
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine()); // 관계 수
        result = -1;

        visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++){
          arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());

          // 양방향으로 데이터 삽입
          arr.get(x).add(y);
          arr.get(y).add(x);
        }
        
        // 노드를 거치는 횟수가 곧 촌수
        // 3 -> 1 -> 2-> 7 = 3회
        dfs(start, target, 0);
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
    static void dfs(int start, int target, int count){
      // 종료 조건
      if(start == target){
        result = count;
        return;
      }

      // 재귀
      for(int i = 0; i < arr.get(start).size(); i++){
        int temp = arr.get(start).get(i);
        if(!visited[temp]){
          visited[temp] = true;
          dfs(temp, target, count + 1);
          visited[temp] = false;
        }
      }
    }
}
