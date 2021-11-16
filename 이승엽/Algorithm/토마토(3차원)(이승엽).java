import java.util.*;
import java.io.*;

public class Main {

	static int[] move_x = { -1, 1, 0, 0, 0, 0 };
	static int[] move_y = { 0, 0, 0, 0, -1, 1 };
	static int[] move_z = { 0, 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] map = new int[H][N][M];

		int cnt = 0;

		ArrayDeque<Position> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[H][N][M];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 0) {
						cnt++;
					} else if (map[k][i][j] == 1) {
						q.add(new Position(i, j, k, 0));
						visited[k][i][j] = true;
					}
				}
			}
		}

		int answer = -1;
		if (cnt != 0) {
			while (!q.isEmpty()) {
				Position now = q.poll();

				for (int i = 0; i < 6; i++) {
					int next_x = now.x + move_x[i];
					int next_y = now.y + move_y[i];
					int next_z = now.z + move_z[i];

					if (next_x < 0 || next_y < 0 || next_z < 0 || next_x >= N || next_y >= M || next_z >= H) {
						continue;
					}
					if (!visited[next_z][next_x][next_y] && map[next_z][next_x][next_y] == 0) {
						visited[next_z][next_x][next_y] = true;
						cnt--;
						q.add(new Position(next_x, next_y, next_z, now.day + 1));
					}

				}
				if (cnt == 0) {
					answer = now.day + 1;
					break;
				}

			}
		}else {
			answer = 0;
		}
		System.out.println(answer);

	}

	static class Position {
		int x, y, z, day;

		public Position(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}

}
