import java.io.*;
import java.util.*;

public class Main {
  static boolean[] visited;
  static int result;
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      boolean finded = false;

      Queue<Pair> qu = new LinkedList<>();
      visited = new boolean[100001];
      qu.offer(new Pair(N, 0));
      visited[N] = true;

      while(!qu.isEmpty()){
        
        Pair tempPair = qu.peek();
        int tempTime = tempPair.time;
        
        
        if (finded){
          break;
        }
        while(!qu.isEmpty()){
          if(qu.peek().time == tempTime){
            Pair pair = qu.poll();
            if(finded){
              break;
            }

            int x1 = pair.position - 1;
            int x2 = pair.position + 1;
            int x3 = pair.position * 2;
            
            int[] moveArr = {x1, x2, x3};

            for (int i = 0; i < moveArr.length; i++){
              if(moveArr[i] >= 0 && moveArr[i] <= 100000 && !visited[moveArr[i]]){
                if(moveArr[i] == K){
                  result = tempTime + 1;
                  finded = true;
                  break;
                }
                visited[moveArr[i]] = true;
                qu.offer(new Pair(moveArr[i], tempTime + 1));
                
              }
            }
          } else {
            break;
          }
        }
      }

      bw.write(result + "");


      br.close();
      bw.flush();
      bw.close();
  }

  static class Pair {
    int position;
    int time;
    Pair(int position, int time) {
      this.position = position;
      this.time = time;
    }
  }
}
