import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		boolean[] visited = new boolean[n];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		int answer = -1;
		
		q.add(x);
		q.add(0);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int now_x = q.poll();
			int depth = q.poll();
			
			if(now_x == y) {
				answer = depth;
				break;
			}
			
			for(int i = 0; i < n; i++) {
				if(!visited[i] && map[now_x][i] == 1) {
					visited[i] = true;
					q.add(i);
					q.add(depth+1);
				}
			}
		}
		
		System.out.println(answer);

	}

}
