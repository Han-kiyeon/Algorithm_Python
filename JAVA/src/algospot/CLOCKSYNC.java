package algospot;

import java.io.IOException;
import java.util.Scanner;

public class CLOCKSYNC {
	static int ans;
	static int SWITCH = 10, CLOCK = 16;
	static int[][] switches = { { 0, 1, 2 }, { 3, 7, 9, 11 }, { 4, 10, 14, 15 }, { 0, 4, 5, 6, 7 }, { 6, 7, 8, 10, 12 },
			{ 0, 2, 14, 15 }, { 3, 14, 15 }, { 4, 5, 7, 14, 15 }, { 1, 2, 3, 4, 5 }, { 3, 4, 5, 9, 13 } };
	static int[] clocks, set;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int tc = 0; tc < C; tc++) {
			clocks = new int[CLOCK];
			for (int clock = 0; clock < CLOCK; clock++)
				clocks[clock] = (sc.nextInt() / 3) % 4;

			set = new int[SWITCH];
			int ans = Integer.MAX_VALUE >> 1;

			solve(0);
			System.out.println(ans == Integer.MAX_VALUE >> 1 ? -1 : ans);
		}
	}

	private static void solve(int depth) {
		if (depth == SWITCH) {
			if (calc()) {
				int sum = 0;
				for (int i = 0; i < SWITCH; i++) {
					sum += set[i];
				}
				if (ans > sum)
					ans = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			set[depth] = i;
			solve(depth + 1);
		}
	}

	private static boolean calc() {
		int[] tmp = new int[CLOCK];
		for (int i = 0; i < SWITCH; i++) {
			for (int j = 0; j < switches[i].length; j++) {
				tmp[switches[i][j]] += set[i];
			}
		}

		for (int i = 0; i < CLOCK; i++) {
			if ((tmp[i] + clocks[i]) % 4 != 0) {
				return false;
			}
		}
		return true;
	}

}