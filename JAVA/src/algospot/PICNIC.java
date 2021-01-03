package algospot;

import java.util.Arrays;
import java.util.Scanner;

public class PICNIC {
	static int N, M, half, ans;
	static int[] data, visit;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			System.out.println();
			N = sc.nextInt();
			M = sc.nextInt();

			half = N >> 1;

			map = new int[N][N];
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}

			ans = 0;
			visit = new int[half + 1];
			data = new int[N];
			makeSet(0);
			System.out.println(ans);
		}
	}

	private static void makeSet(int v) {
		if (v == N) {
			if (check()) {
				System.out.println(Arrays.toString(data));
				ans++;
			}
			return;
		}

		for (int i = 1; i <= half; i++) {
			if (visit[i] < 2) {
				visit[i]++;
				data[v] = i;
				makeSet(v + 1);
				data[v] = 0;
				visit[i]--;
			}

		}

	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (data[i] == data[j]) {
					if (map[i][j] == 0)
						return false;
					break;
				}
			}
		}
		return true;
	}

}
