import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {-1, 1, 0, 0, 0, 0};
  static int[] dy = {0, 0, -1, 1, 0, 0};
  static int[] dz = {0, 0, 0, 0, -1, 1};
  static int[][][] graph;
  static boolean[][][] visited;
  static int tomato; // 익어야 하는 토마토 개수
  static int result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken()); // y
    int N = Integer.parseInt(st.nextToken()); // x
    int H = Integer.parseInt(st.nextToken()); // z

    tomato = 0;
    graph = new int[N][M][H];
    visited = new boolean[N][M][H];
    Queue<Pair> qu= new LinkedList<>();

    // 그래프 초기화
    for(int h = 0; h < H; h++){
      for(int n = 0; n < N; n++){
        st = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++){
          int temp = Integer.parseInt(st.nextToken());
          graph[n][m][h] = temp;
          if (temp == 0){
            tomato++;
          } else if(temp == 1){
            qu.offer(new Pair(n, m, h, 1));
            visited[n][m][h] = true;
          }
        }
      }
    }

    // 모든 토마토가 익어있는 상태
    if (tomato == 0){
      bw.write(0 + "");
    } else {
      // bfs
      while(!qu.isEmpty() && tomato != 0){
        // day가 동일한 친구들을 전부 다 뽑아서 방문처리 및 tomato를 익혀야 함
        Pair tempPair = qu.peek();
        int tempDay = tempPair.day;
        for(int i = 0; i < qu.size(); i++){
          if(qu.size() < 1){
            break;
          }
          if(tomato == 0){
            break;
          }
          Pair pair = qu.peek();
          if(pair.day != tempDay){
            break;
          }
          pair = qu.poll();
          for(int j = 0; j < 6; j++){
            int x = pair.x + dx[j];
            int y = pair.y + dy[j];
            int z = pair.z + dz[j];

            if (x > -1 && x < N && y > -1 && y < M && z > -1 && z < H && !visited[x][y][z] && graph[x][y][z] == 0){
              visited[x][y][z] = true;
              graph[x][y][z] = 1;
              qu.offer(new Pair(x, y, z, tempDay + 1));
              tomato--;
              if(tomato == 0){
                result = tempDay;
                break;
              }
            }
          }
        }
      }

      if(tomato > 0){
        result = -1;
      }

      bw.write(result + "");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  static class Pair{
    public int x;
    public int y;
    public int z;
    public int day;
  
    Pair(int x, int y, int z, int day){
      this.x = x;
      this.y = y;
      this.z = z;
      this.day = day;
    }
  }
    
}
