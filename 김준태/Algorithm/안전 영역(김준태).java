import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int N;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    

    ArrayList<Integer> list = new ArrayList<>();
    int areaMax = 1;
    N = Integer.parseInt(br.readLine());
    int[][] graph = new int[N][N];

    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++){
        int temp = Integer.parseInt(st.nextToken());
        graph[i][j] = temp;
        if(!list.contains(temp)){
          list.add(temp);
        }
      }
    }

    
    Collections.sort(list);

    //방문한적이 없고, 현재 물높이 보다 높을 경우 영역 ++ Math.max
    for (int i = 0; i < list.size(); i++){
      boolean[][] visited = new boolean[N][N];
      int height = list.get(i); // 물높이
      int area = 0;

      for(int n = 0; n < N; n++){
        for(int m = 0; m < N; m++){
          if(graph[n][m] > height){
            if(!visited[n][m]){
              visited[n][m] = true;
              dfs(n, m, height, visited, graph);
              area++;
            }
          }
        }
      }

      areaMax = Math.max(areaMax, area);
    }
    bw.write(areaMax + "");
   
    br.close();
    bw.flush();
    bw.close();
  }

  static void dfs(int x, int y, int height, boolean[][] visited, int[][] graph){
    // 재귀
    for (int i = 0; i < 4; i++){
      int tx = x + dx[i];
      int ty = y + dy[i];

      if(tx > -1 && tx < N && ty > -1 && ty < N && graph[tx][ty] > height && !visited[tx][ty]){
        visited[tx][ty] = true;
        dfs(tx, ty, height, visited, graph);
      }
    }
  }
}
