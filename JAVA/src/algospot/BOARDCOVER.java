package algospot;

import java.util.Scanner;

public class BOARDCOVER {
	static int H, W, ans;
	static int[][] map;

	static int[][][] block = { { { 0, 0 }, { 0, 1 }, { 1, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 0 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } }, };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int tc = 0; tc < C; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new int[H][W];
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				String input = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = input.charAt(j) == '.' ? 0 : 1;
					if (map[i][j] == 0)
						cnt++;
				}
			}

			if (cnt % 3 != 0) {
				System.out.println(0);
			} else {
				ans = 0;
				solve(cnt);
				System.out.println(ans);
			}
		}
	}

	private static void solve(int cnt) {
		if (cnt == 0) {
			ans++;
			return;
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 0) {
					for (int k = 0; k < 4; k++) {
						if (check(k, i, j)) {
							set(k, i, j, 1);
							solve(cnt - 3);
							set(k, i, j, 0);
						}
					}
					return;
				}
			}
		}

	}

	private static void set(int k, int r, int c, int v) {
		for (int i = 0; i < 3; i++) {
			int nr = r + block[k][i][0];
			int nc = c + block[k][i][1];
			map[nr][nc] = v;
		}
	}

	private static boolean check(int k, int r, int c) {
		for (int i = 0; i < 3; i++) {
			int nr = r + block[k][i][0];
			int nc = c + block[k][i][1];
			if (!isRange(nr, nc) || map[nr][nc] == 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRange(int nr, int nc) {
		if (0 <= nr && nr < H && 0 <= nc && nc < W)
			return true;
		return false;
	}
}