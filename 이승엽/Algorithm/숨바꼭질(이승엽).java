import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[100001];

		q.add(N);
		q.add(0);
		int answer = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			int depth = q.poll();
			if (now == K) {
				answer = depth;
				break;
			}
			// -1
			if (now-1 >= 0 && !visited[now-1]) {
				q.add(now - 1);
				q.add(depth + 1);
				visited[now-1] = true;
			}
			// +1
			if (now+1 <= 100000 && !visited[now+1]) {
				q.add(now + 1);
				q.add(depth + 1);
				visited[now+1] = true;
			}
			// *2
			if (now * 2 <= 100000 && !visited[now*2]) {
				q.add(now * 2);
				q.add(depth + 1);
				visited[now*2] = true;
			}

		}
		System.out.println(answer);
	}

}