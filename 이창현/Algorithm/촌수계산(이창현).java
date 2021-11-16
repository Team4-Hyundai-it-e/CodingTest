package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2644 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		solution(n, map, x, y);
		System.out.println(result);

	}

	static boolean[] chk;
	static int[][] arr;
	static int row;
	static int result;
	static int end;
	static void solution(int n, int[][] g, int x, int y) {
		chk = new boolean[n];
		arr = g;
		row = n;
		result = -1;
		end = y;
		chk[x] = true;
		dfs(chk, arr, x,0);

	}

	static void dfs(boolean[] chk, int[][] arr, int now, int depth) {
		
		for (int i = 0; i < row; i++) {
			if (!chk[i] && arr[now][i] == 1) {
				if(i==end) {
					chk[i] = true;
					result = depth+1;
					return;
				}
				
				chk[i] = true;
				dfs(chk, arr, i, depth+1);
		
			}
		}

	}

}